package data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import data.entities.AuthorDao
import data.entities.AuthorEntity
import data.entities.BookDao
import data.entities.BookEntity
import junit.framework.TestCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class LibraryDatabaseTest : TestCase(){
    private lateinit var bookDao: BookDao
    private lateinit var authorDao: AuthorDao
    private lateinit var db: LibraryDatabase

    @Before
    public fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, LibraryDatabase::class.java).build()
        bookDao = db.bookDao()
        authorDao = db.authorDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }

    @Test
    fun writeBookAndReadList() = runBlocking {

        val book_1 = BookEntity("Crime and Punishment", 3, "Santillana", "Drama", 1)
        val book_2 = BookEntity("GOL", 1, "Santillana", "Drama", 2)

        val authorID_1 = AuthorEntity(book_1.authorId, "Dostoyesky", 5)
        val authorID_2 = AuthorEntity(book_2.authorId, "Stallings", 10)

        authorDao.insertAuthor(authorID_2)
        authorDao.insertAuthor(authorID_1)


        bookDao.insertBook(book_1)
        bookDao.insertBook(book_2)


        val books: List<BookEntity> = bookDao.getBooks().first()
        assertTrue("hello", books.size == 2)
    }


}