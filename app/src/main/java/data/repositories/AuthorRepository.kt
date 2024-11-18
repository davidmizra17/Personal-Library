package data.repositories;

import data.entities.AuthorDao;
import data.entities.AuthorEntity
import kotlinx.coroutines.flow.Flow

class AuthorRepository(private val authorDao: AuthorDao) {

    fun getAuthors(): Flow<List<AuthorEntity>> = authorDao.getAuthors()

    suspend fun getAuthorById(author: AuthorEntity): AuthorEntity = authorDao.getAuthorById(author.id)

    suspend fun getAuthorId(author: AuthorEntity): Int = authorDao.getAuthorId(author.name)

    suspend fun getAuthorByName(author: AuthorEntity): AuthorEntity = authorDao.getAuthorByName(author.name)

    suspend fun insertAuthor(authorEntity: AuthorEntity) = authorDao.insertAuthor(authorEntity)

}


