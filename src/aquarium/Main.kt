package co.at.sdt.herb.kotlin.aquarium

fun main(args: Array<String>) {
    buildAquarium()
}

private fun buildAquarium() {
    val myAquarium = Aquarium()
    println(
        "length: ${myAquarium.length}"
                + " width: ${myAquarium.width}"
                + " height: ${myAquarium.height}"
    )
    println("volume: ${myAquarium.volume} liters")

    myAquarium.height = 80
    println("height: ${myAquarium.height}")
    println("volume: ${myAquarium.volume} liters")

    myAquarium.volume = 100
    println("height: ${myAquarium.height}")
}
