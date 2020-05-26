package co.at.sdt.herb.kotlin.aquarium

import java.util.*

fun main() {
    repeat(9) { gamePlay(rollDice2(6)) }
}

fun gamePlay(diceRoller: Int) {
    println(diceRoller)
}

val rollDice = { sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}