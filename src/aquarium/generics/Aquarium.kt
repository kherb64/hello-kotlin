package co.at.sdt.herb.kotlin.aquarium.generics

import kotlin.reflect.jvm.jvmName

open class WaterSupply(var needProcessing: Boolean)

class TapWater : WaterSupply(needProcessing = true) {
    fun addChemicalCleaners() {
        needProcessing = false
        println("adding chemicals")
    }
}

class FishStoreWater : WaterSupply(needProcessing = false)

class LakeWater : WaterSupply(needProcessing = true) {
    fun filter() {
        needProcessing = false
        println("filtering")
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needProcessing) {
            cleaner.clean(waterSupply)
        }
        println("adding water from ${waterSupply::class.simpleName}")
    }
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

class LakeWaterCleaner : Cleaner<LakeWater> {
    override fun clean(waterSupply: LakeWater) {
        waterSupply.filter()
    }
}

fun Aquarium<*>.addItemTo() {
    println("item added to ${this.waterSupply::class.simpleName} ${this::class.simpleName}")
}

fun Aquarium<*>.isWaterClean() {
    println("${this.waterSupply::class.simpleName} aquarium needs processing: ${this.waterSupply.needProcessing}")
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = this is R
inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T
fun WaterSupply.type() = this::class.simpleName

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    println("${aquarium.hasWaterSupplyOfType<TapWater>()}")
    println("${aquarium.waterSupply.isOfType<LakeWater>()}")
    println("${aquarium.waterSupply.type()}")
    aquarium.isWaterClean()
    aquarium.addWater(TapWaterCleaner())
    aquarium.isWaterClean()
    aquarium.addItemTo()

    val aquarium2 = Aquarium(LakeWater())
    aquarium.isWaterClean()
    aquarium2.addWater(LakeWaterCleaner())
    aquarium.isWaterClean()
    aquarium2.addItemTo()
}

fun main() {
    genericExample()
}