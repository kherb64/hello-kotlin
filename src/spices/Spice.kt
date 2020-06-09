package co.at.sdt.herb.kotlin.spices

sealed class Spice(
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

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

interface SpiceColor {
    val color: Color
}

object GreenSpiceColor : SpiceColor {
    override val color: Color = Color.GREEN
}

object RedSpiceColor : SpiceColor {
    override val color: Color = Color.RED
}

object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

data class SpiceContainer(val spice: Spice) {
    val label = "${spice.color} ${spice.name} ${spice.spiciness} ${spice.heat}"
}

fun main() {
    val curry = Curry("hot")
    curry.prepareSpice()

    val spiceCabinet = listOf(
        SpiceContainer(Curry("mild")),
        SpiceContainer(Curry("medium", RedSpiceColor)),
        SpiceContainer(Curry("spicy", GreenSpiceColor))
    )
    for (element in spiceCabinet) println(element.label)
}