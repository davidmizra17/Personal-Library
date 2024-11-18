package data.repositories

import data.entities.BookDao
import data.entities.BookEntity
import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookDao: BookDao){

    //get all books reactively
    fun getBooks(): Flow<List<BookEntity>> = bookDao.getBooks()

    //get all books given an author id as flow
    fun getBooksByAuthorId(authorId: Int): Flow<List<BookEntity>> = bookDao.getBooksByAuthorId(authorId)

    suspend fun insertBook(book: BookEntity) = bookDao.insertBook(book)

    suspend fun getBook(book: BookEntity) = bookDao.getBook(book.name)
}