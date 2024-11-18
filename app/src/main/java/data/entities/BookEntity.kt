package data.entities
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = AuthorEntity::class,
            parentColumns = ["id"],
            childColumns = ["authorId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class BookEntity(
    val name: String,
    val authorId: Int,
    val publisher: String,
    val genre: String,
    @PrimaryKey (autoGenerate = true)val id: Int

)

