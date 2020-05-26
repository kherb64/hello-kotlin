package co.at.sdt.herb.kotlin.aquarium

fun main() {
    whatShouldIDoToday("sad")
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "sunny",
    temperature: Int = 24 // Celsius
): String {
    return when {
        mood == "happy" && weather == "sunny" -> "go for a walk"
        else -> "stay home an read"
    }
}
