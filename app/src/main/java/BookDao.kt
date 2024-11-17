import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(newBookEntity: BookEntity)

    @Query("SELECT * FROM BookEntity")
    suspend fun getBooks(): List<BookEntity>

    @Query("SELECT * FROM BookEntity WHERE name = :name_")
    suspend fun getBook(name_: String): BookEntity

}
