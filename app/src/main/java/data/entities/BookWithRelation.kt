package data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class BookWithRelation (
    @Embedded val book: BookEntity,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "id"
    )

    val author: AuthorEntity

)