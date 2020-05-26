package co.at.sdt.herb.kotlin.aquarium

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    // sizes in cm

    open var volume: Int // dm3
        get() = length * width * height / 1000
        set(value) {
            height = (value * 1000) / (length * width)
        }

    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        // need 2000 cm3 water for 1 cm of fish

        val water = numberOfFish * 2 // dm3
        volume = (water / 0.9).toInt()
    }
}

class TowerTank(var diameter: Int = 45, height: Int) : Aquarium(diameter, diameter, height) {
    // sizes in cm

    override var water = volume * 0.8

    override var volume: Int // l
        get() = (diameter * diameter * PI * height / 4000).toInt()
        set(value) {
            height = (value * 4000 / (diameter * diameter * PI)).toInt()
        }
}