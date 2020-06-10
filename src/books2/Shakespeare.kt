package co.at.sdt.herb.kotlin.books2

fun main() {
    val allBooks = setOf(
        "Heinrich VI",
        "Richard III",
        "Hamlet",
        "Othello"
    )

    val library = mapOf("Shakespeare" to allBooks)
    println("$library")
    println("has Hamlet? ${library.any { it.value.contains("Hamlet") }}")

    val moreBooks = mutableMapOf("Wallenstein" to "Schiller")
    moreBooks.getOrPut("MacBeth") { "Shakespeare" }
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    println("$moreBooks")
}