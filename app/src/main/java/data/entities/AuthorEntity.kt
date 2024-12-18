package data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthorEntity(
    @PrimaryKey (autoGenerate = true) val id: Int,
    val name: String,
    val globalRanking: Int
)