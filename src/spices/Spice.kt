package co.at.sdt.herb.kotlin.spices

abstract class Spice(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor
) :
    SpiceColor by color {
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
        println("${color.color} $name $spiciness $heat")
    }

    abstract fun prepareSpice()
}

interface Grinder {
    fun grind() {
        println("grinding")
    }
}

class Curry(spiciness: String, color: SpiceColor = YellowSpiceColor) :
    Spice("curry", spiciness, color),
    Grinder {

    override fun prepareSpice() {
        grind()
    }
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color: String = "yellow"
}

fun main() {
    val curry = Curry("hot")
    curry.prepareSpice()
}