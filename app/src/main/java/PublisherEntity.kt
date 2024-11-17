import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PublisherEntity (
    @PrimaryKey (autoGenerate = true)val id: Int,
    val name: String
)

