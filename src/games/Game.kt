package co.at.sdt.herb.kotlin.games

enum class Directions { NORTH, SOUTH, EAST, WEST, START, END }

class Game {
    var path = mutableListOf<Directions>(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }

    val end = {
        path.add(Directions.END)
        println("Game over")
        println(path)
        path.clear()
        false
    }

    fun makeMove(command: String?) {
        when (command) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}

fun move(where: () -> Boolean) {
    where.invoke()
}

fun main() {
    val game = Game()
    println(game.path)
    /* game.north()
    game.east()
    game.south()
    game.west()
    game.end() */
    while (!game.path.contains(Directions.END)) {
        game.makeMove(readLine())
        println(game.path)
    }
    println(game.path)
}