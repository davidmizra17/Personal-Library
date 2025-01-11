package data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import data.entities.AuthorDao
import data.entities.AuthorEntity
import data.entities.BookDao
import data.entities.BookEntity
import java.util.concurrent.Executors

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

        fun prepopulateBooks(): List<BookEntity> {
            return listOf(
                BookEntity("The Great Gatsby", 1, "Scribner", "Fiction", 0),
                BookEntity("1984", 2, "Secker & Warburg", "Dystopian", 0),
                BookEntity("To Kill a Mockingbird", 3, "J.B. Lippincott & Co.", "Fiction", 0),
                BookEntity("Moby-Dick", 4, "Harper & Brothers", "Adventure", 0),
                BookEntity("Pride and Prejudice", 5, "T. Egerton", "Romance", 0),
                BookEntity("War and Peace", 6, "The Russian Messenger", "Historical Fiction", 0),
                BookEntity("The Catcher in the Rye", 7, "Little, Brown and Company", "Fiction", 0),
                BookEntity("Crime and Punishment", 8, "The Russian Messenger", "Philosophical Fiction", 0),
                BookEntity("The Hobbit", 9, "George Allen & Unwin", "Fantasy", 0),
                BookEntity("Brave New World", 10, "Chatto & Windus", "Science Fiction", 0)
            )
        }

        fun getInstance(context: Context): LibraryDatabase {

            //Patron de diseño singleton
            //Asegurar que solo una sola instancia vaya a ser creada con synchronized(this)

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibraryDatabase::class.java,
                    "library_database"
                ).addCallback(object: Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase){
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute{
                            getInstance(context).bookDao().insertBooks(prepopulateBooks())
                        }
                    }
                })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }





}


