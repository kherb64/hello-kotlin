package co.at.sdt.herb.kotlin.games

enum class Directions { NORTH, SOUTH, EAST, WEST, START, END }

class Game(val location: Location) {
    var path = mutableListOf<Directions>(Directions.START)

    val north = {
        path.add(Directions.NORTH)
        location.updateLocation(Directions.NORTH)
    }
    val south = {
        path.add(Directions.SOUTH)
        location.updateLocation(Directions.SOUTH)
    }
    val east = {
        path.add(Directions.EAST)
        location.updateLocation(Directions.EAST)
    }
    val west = {
        path.add(Directions.WEST)
        location.updateLocation(Directions.WEST)
    }

    val end = {
        path.add(Directions.END)
        println("Game over")
    }

    fun makeMove(command: String?) {
        when (command) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
        println("path $path")
    }
}

fun move(where: () -> Unit) {
    where.invoke()
}

class Location(private val width: Int = 4, private val height: Int = 4) {
    val map = Array(width) {
        val w = ('A'.toInt() + it).toChar()
        Array(height) {
            val h = ('1'.toInt() + it).toChar()
            "$w$h"
        }
    }

    private var curLoc = Pair(0, 0) // currentLocation: width, height

    fun updateLocation(move: Directions) {
        when (move) {
            Directions.NORTH -> curLoc = Pair(curLoc.first, (height + curLoc.second + 1).rem(height))
            Directions.SOUTH -> curLoc = Pair(curLoc.first, (height + curLoc.second - 1).rem(height))
            Directions.EAST -> curLoc = Pair((width + curLoc.first + 1).rem(width), curLoc.second)
            Directions.WEST -> curLoc = Pair((width + curLoc.first - 1).rem(width), curLoc.second)
            else -> {
            }
        }
        println("location ${map[curLoc.first][curLoc.second]}")
    }
}

fun main() {
    val game = Game(Location(8, 8))
    println(game.path)
    /* game.north()
    game.east()
    game.south()
    game.west()
    game.end() */
    while (!game.path.contains(Directions.END)) {
        game.makeMove(readLine())
    }
}