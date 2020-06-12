package co.at.sdt.herb.kotlin.games

enum class Directions { NORTH, SOUTH, EAST, WEST, START, END }

class Game {
    var path = mutableListOf<Directions>(Directions.START)

    val north = { path.add(Directions.NORTH); this }
    val south = { path.add(Directions.SOUTH); this }
    val east = { path.add(Directions.EAST); this }
    val west = { path.add(Directions.WEST); this }

    val end = {
        path.add(Directions.END)
        println("Game over")
        println(path)
        path.clear()
        false
    }

}

fun main() {
    val game = Game()
    println(game.path)
    game.north().east().south().west().end()
    println(game.path)
}