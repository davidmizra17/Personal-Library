package data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.entities.AuthorDao
import data.entities.AuthorEntity
import data.entities.BookDao
import data.entities.BookEntity

@Database(
    entities = [BookEntity::class, AuthorEntity::class],
    version = 2,
    exportSchema = true
)

abstract class LibraryDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun authorDao(): AuthorDao

    companion object{
        @Volatile

        private var INSTANCE: LibraryDatabase? = null

        fun getInstance(context: Context): LibraryDatabase {

            //Patron de diseño singleton
            //Asegurar que solo una sola instancia vaya a ser creada con synchronized(this)

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibraryDatabase::class.java,
                    "library_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}


