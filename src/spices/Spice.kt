package co.at.sdt.herb.kotlin.spices

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "hot" -> 7
            "very hot" -> 10
            else -> 0
        }
    init {
        println("$name $spiciness $heat")
    }
}

fun makeSalt() { Spice("salt")}

fun main() {
    val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "very hot")
    )

    val salt = makeSalt()
}