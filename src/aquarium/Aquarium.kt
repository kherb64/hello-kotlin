package co.at.sdt.herb.kotlin.aquarium

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    // sizes in cm

    var volume: Int // dm3
        get() = length * width * height / 1000
        set(value) {
            height = (value * 1000) / (length * width)
        }

    var water = volume * 0.9

    constructor(numberOfFish: Int): this() {
        // need 2000 cm3 water for 1 cm of fish

        val water = numberOfFish * 2 // dm3
        volume = (water / 0.9).toInt()
    }
}