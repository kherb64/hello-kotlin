package co.at.sdt.herb.kotlin.aquarium

fun main() {
    for (i in 1..10) {
        val fortune = getFortuneCookie(getBirthday())
        println(fortune)
        if (fortune.startsWith("Take it easy")) break
    }
}

private fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    val i = when (birthday) {
        28, 31 -> 6
        in 1..7 -> 0
        else -> birthday.rem(fortunes.size)
    }
    return fortunes[i]
}
