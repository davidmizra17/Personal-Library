import androidx.room.Dao
import androidx.room.Query

@Dao
interface PublisherDao{
    @Query("SELECT * FROM PublisherEntity")
    suspend fun getPublishers(): List<PublisherEntity>
}
