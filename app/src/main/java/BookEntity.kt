
import androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = AuthorEntity::class,
            parentColumns = ["id"],
            childColumns = ["author_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PublisherEntity::class,
            parentColumns = ["id"],
            childColumns = ["publisher_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = GenreEntity::class,
            parentColumns = ["id"],
            childColumns = ["genre_id"],
            onDelete = ForeignKey.CASCADE
)
    ]

)
data class BookEntity(
    val name: String,
    val author_id: Int,
    val publisher_id: Int,
    val genre_id: Int,
    @PrimaryKey (autoGenerate = true)val id: Int

)

