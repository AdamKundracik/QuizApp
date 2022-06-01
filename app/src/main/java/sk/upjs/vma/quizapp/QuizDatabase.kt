package sk.upjs.vma.quizapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [QuizDB::class], version = 1, exportSchema = false)
@TypeConverters(UuidConverter::class)
abstract class QuizDatabase: RoomDatabase() {


    abstract fun quizDao(): QuizDao

        companion object {
            @Volatile
            private var INSTANCE: QuizDatabase? = null

            fun getDatabase(context: Context, scope: CoroutineScope): QuizDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuizDatabase::class.java,
                        "quiz_database"
                    ).addCallback(QuizDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                    instance
                }

            }
        }
    class QuizDatabaseCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch {
                    populateDatabase(it.quizDao())
                }
            }
        }

        private fun populateDatabase(weblinkDao: Any) {
        }


    }

    }