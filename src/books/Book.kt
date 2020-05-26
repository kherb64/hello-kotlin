package co.at.sdt.herb.kotlin.books

open class Book(val title: String, val author: String) {
    var currentPage = 0

    open fun readPage() {
        currentPage++
    }
}

class eBook(title: String, author: String, val format: String = "text") : Book(title, author) {
    var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}

fun main() {
    val b = Book("The holy Bible", "4 Evangelists")
    println(b)
    val e = eBook("The holy Bible", "4 Evangelists")
    println(e)
}