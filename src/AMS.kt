package co.at.sdt.herb.kotlin.aquarium

import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 22, // celsius
    dirty: Int = 20 // percent
): Boolean {
    return true
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if (shouldChangeWater(day))
        println("Change the water today")
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "TuesDay" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "TuesDay", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun canAddFish(
    tankSize: Double, // gallons
    currentFish: List<Int>, // list of current fish sizes
    fishSize: Int = 2, // size in inches of fish to add
    hasDecorations: Boolean = true
): Boolean {
    val totalLength = currentFish.sum()
    val decoFactor = if (hasDecorations) 0.8 else 1.0
    return totalLength + fishSize <= tankSize * decoFactor
}