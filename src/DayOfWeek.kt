package co.at.sdt.herb.kotlin.aquarium

import java.util.*

fun main () {
    dayOfWeek()
}

fun dayOfWeek() {
    val dayName = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "unknown day"
    }
    println("What day is it today? $dayName")
}
