package co.at.sdt.herb.kotlin.buildings

open class BaseBuildingMaterial {
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building<out T : BaseBuildingMaterial>(val material: T) {
    private val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("needing $actualMaterialsNeeded ${material::class.simpleName}")
    }
}

fun <T : BaseBuildingMaterial> Building<T>.isSmall(): Boolean = actualMaterialsNeeded < 500

fun <T : BaseBuildingMaterial> Building<T>.description(): String {
    return "${if (isSmall()) "small" else "large"} ${material::class.simpleName} building"
}

fun main() {
    val wood = Building(Wood())
    wood.build()
    println(wood.description())
    val brick = Building(Brick())
    brick.build()
    println(brick.description())
}