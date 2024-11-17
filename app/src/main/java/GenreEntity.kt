import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

class GenreEntity(
    @PrimaryKey (autoGenerate = true) val id: Int,
    val name: String
)
