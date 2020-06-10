package co.at.sdt.herb.kotlin.aquarium.generics

open class WaterSupply(var needProcessing: Boolean)

class TapWater : WaterSupply(needProcessing = true) {
    fun addChemicalCleaners() {
        needProcessing = false
    }
}

class FishStoreWater : WaterSupply(needProcessing = false)

class LakeWater : WaterSupply(needProcessing = true) {
    fun filter() {
        needProcessing = false
    }
}

class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needProcessing) { "water supply needs processing" }
        println("adding water from $waterSupply")
    }
}

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    aquarium.addWater()

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
}

fun main() {
    genericExample()
}