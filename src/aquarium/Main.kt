package co.at.sdt.herb.kotlin.aquarium

fun main(args: Array<String>) {
    buildAquarium()
}

private fun buildAquarium() {
    val myAquarium = Aquarium()
    printAquarium(myAquarium)

    myAquarium.height = 80
    printAquarium(myAquarium)

    val smallAquarium = Aquarium(20, 15, 30)
    printAquarium(smallAquarium, "Small aquarium")

    val smallAquarium2 = Aquarium(numberOfFish = 9)
    printAquarium(smallAquarium2, "Small aquarium2")

}

fun printAquarium (aquarium: Aquarium, name:String = "") {
    println(
        "$name volume: ${aquarium.volume} liters"
                + " with length: ${aquarium.length}"
                + " width: ${aquarium.width}"
                + " height: ${aquarium.height}"
    )
}