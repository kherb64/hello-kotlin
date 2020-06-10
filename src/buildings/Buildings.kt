package co.at.sdt.herb.kotlin.buildings

open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}

class Wood(): BaseBuildingMaterial() {
    override val numberNeeded = 4
}
class Brick(): BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building<T: BaseBuildingMaterial>(val material: T) {
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("needing $actualMaterialsNeeded ${material::class.simpleName}")
    }
}

fun main() {
    Building(Wood()).build()
    Building(Brick()).build()
}