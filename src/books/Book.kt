package co.at.sdt.herb.kotlin.books

import java.lang.Integer.max
import kotlin.random.Random

const val MAX_NUM_BOOKS = 3
const val WEIGTH_PER_PAGE = 1.5

open class Book(val title: String, val author: String, val year: Int, var pages: Int) {
    companion object {
        const val BASE_URL = "https://library.com/"
    }

    var currentPage = 0

    open fun readPage() {
        currentPage++
    }

    fun canBorrow(numBooks: Int) = numBooks < MAX_NUM_BOOKS

    fun printUrl() {
        println("$BASE_URL$title.html")
    }
}

fun Book.weight() = pages * WEIGTH_PER_PAGE

fun Book.tornPages(torn: Int) {
    pages = max(pages - torn, 0)
}

class eBook(title: String, author: String, year: Int, pages: Int, val format: String = "text") :
    Book(title, author, year, pages) {
    var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random.nextInt(12))
    }

    fun playWithToy(toy: PuzzleToy) {
        toy.eat(Random.nextInt(5))
    }
}

class PuzzleToy(var treats: Int) {
    fun eat(eaten: Int) {
        treats = max(treats - eaten, 0)
    }
}

fun main() {
    val bible = Book("The holy Bible", "4 Evangelists", 1, 1500)
    println(bible)
    val eBible = eBook("The holy Bible", "4 Evangelists", 1, 5000)
    println(eBible)

    bible.printUrl()
    eBible.printUrl()

    val puppy = Puppy()
    puppy.playWithBook(bible)
    println("${bible.pages}")

    val toy = PuzzleToy(15)
    puppy.playWithToy(toy)
    println("${toy.treats}")
}