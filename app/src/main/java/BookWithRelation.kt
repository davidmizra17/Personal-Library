import androidx.room.Embedded
import androidx.room.Relation

data class BookWithRelation (
    @Embedded val book: BookEntity,
    @Relation(
        parentColumn = "author_id",
        entityColumn = "id"
    )

    val author: AuthorEntity,
    @Relation(
        parentColumn = "publisher_id",
        entityColumn = "id"
    )

    val publisher: PublisherEntity,

    @Relation(
        parentColumn = "genre_id",
        entityColumn = "id"
    )

    val genre: GenreEntity
)