package co.at.sdt.herb.kotlin.aquarium

class Aquarium {
    var length: Int = 100 // cm
    var width: Int = 20
    var height: Int = 40

    var volume: Int // dm3
        get() = length * width * height / 1000
        set(value) {
            height = (value * 1000) / (length * width)
        }
}