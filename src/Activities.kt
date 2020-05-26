package co.at.sdt.herb.kotlin

fun main() {
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    println(whatShouldIDoToday(getMoodFromUser()))
}

fun getMoodFromUser(): String {
    print("How do you feel: ")
    return readLine() ?: ""
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "sunny",
    temperature: Int = 24 // Celsius
): String {
    fun isHot(temperature: Int) = temperature > 35

    fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"

    fun isSadRainyCold(
        mood: String, weather: String,
        temperature: Int
    ) = mood == "sad" && weather == "rainy" && temperature == 0

    return when {
        isHappySunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "stay home an read"
    }
}
