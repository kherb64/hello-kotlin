package co.at.sdt.herb.kotlin.aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
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

    val tower = TowerTank(25, 30)
    printAquarium(tower)
}

fun printAquarium (aquarium: Aquarium, name:String = "") {
    println(
        "$name volume: ${aquarium.volume} liters"
                + " with length: ${aquarium.length}"
                + " width: ${aquarium.width}"
                + " height: ${aquarium.height}"
    )
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark ${shark.color}\nPlecostomus ${pleco.color}")

    shark.eat()
    pleco.eat()
}

fun feedFish(fish: FishAction) {
    // make some food
    fish.eat()
}