package co.at.sdt.herb.kotlin.books2

class Book(val title: String, val author: String, val year: Int) {
    fun titleAuthor() = title to author
    fun titleAuthorYear() = Triple(title, author, year)
}

fun main(){
    val book = Book("title","author", 2020)
    val bta = book.titleAuthor()
    val btay = book.titleAuthorYear()
    println("Here is your book ${bta.first} written by ${bta.second} in ${btay.third}")
}