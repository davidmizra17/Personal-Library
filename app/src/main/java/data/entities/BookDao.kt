package data.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(newBookEntity: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(books: List<BookEntity>)

    @Query("SELECT * FROM BookEntity")
    fun getBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM BookEntity WHERE title = :title_")
    suspend fun getBook(title_: String): BookEntity

    //Filtrar libros por autor
    @Query("SELECT b.id, b.title, b.genre, b.authorId, b.publisher FROM BookEntity as b WHERE b.authorId = :id_")
    fun getBooksByAuthorId(id_: Int): Flow<List<BookEntity>>



}
