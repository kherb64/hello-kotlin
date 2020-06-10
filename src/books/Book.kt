package co.at.sdt.herb.kotlin.books

const val MAX_NUM_BOOKS = 3

open class Book(val title: String, val author: String) {
    companion object {
        const val BASE_URL = "https://library.com/"
    }
    var currentPage = 0

    open fun readPage() {
        currentPage++
    }

    fun canBorrow(numBooks:Int) = numBooks < MAX_NUM_BOOKS

    fun printUrl() {
        println("$BASE_URL$title.html")
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

    b.printUrl()
    e.printUrl()
}