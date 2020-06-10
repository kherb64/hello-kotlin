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

fun addItemTo(aquarium: Aquarium<WaterSupply>) {
    println("item added to ${aquarium.waterSupply::class.simpleName} ${aquarium::class.simpleName}")
}

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("${aquarium.waterSupply::class.simpleName} aquarium needs processing: ${aquarium.waterSupply.needProcessing}")
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = this is R
inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T
fun WaterSupply.type() = this::class.simpleName

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    println("${aquarium.hasWaterSupplyOfType<TapWater>()}")
    println("${aquarium.waterSupply.isOfType<LakeWater>()}")
    println("${aquarium.waterSupply.type()}")
    isWaterClean(aquarium)
    aquarium.addWater(TapWaterCleaner())
    isWaterClean(aquarium)
    addItemTo(aquarium)

    val aquarium2 = Aquarium(LakeWater())
    isWaterClean(aquarium2)
    aquarium2.addWater(LakeWaterCleaner())
    isWaterClean(aquarium2)
    addItemTo(aquarium2)
}

fun main() {
    genericExample()
}