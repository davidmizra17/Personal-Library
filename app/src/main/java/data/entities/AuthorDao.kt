package data.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(authorEntity: AuthorEntity)

    @Query("SELECT * FROM AuthorEntity WHERE name = :name_")
    suspend fun getAuthorByName(name_: String): AuthorEntity

    @Query("SELECT * FROM AuthorEntity")
    fun getAuthors(): Flow<List<AuthorEntity>>

    @Query("SELECT id FROM AuthorEntity WHERE name = :name_")
    suspend fun getAuthorId(name_: String): Int

    @Query("SELECT * FROM AuthorEntity WHERE id = :id_")
    suspend fun getAuthorById(id_: Int): AuthorEntity

}