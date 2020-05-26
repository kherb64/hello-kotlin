package co.at.sdt.herb.kotlin.spices

class SimpleSpice {
    val name: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}

fun main() {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} ${simpleSpice.heat}")
}