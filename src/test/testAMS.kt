package co.at.sdt.herb.kotlin.aquarium.test

import co.at.sdt.herb.kotlin.aquarium.canAddFish

fun main() {
    testCanAddFish()
}

private fun testCanAddFish() {
    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
}