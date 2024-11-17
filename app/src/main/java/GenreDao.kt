import androidx.room.Dao
import androidx.room.Query

@Dao
interface GenreDao{

    @Query("SELECT * FROM GenreEntity")
    suspend fun getGenres(): List<GenreEntity>

}