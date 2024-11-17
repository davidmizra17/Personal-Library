import androidx.room.Dao
import androidx.room.Query


@Dao
interface AuthorDao {

    @Query("SELECT * FROM AuthorEntity WHERE name = :name_")
    suspend fun getAuthor(name_: String): AuthorEntity

    @Query("SELECT * FROM AuthorEntity")
    suspend fun getAuthors(): List<AuthorEntity>

}