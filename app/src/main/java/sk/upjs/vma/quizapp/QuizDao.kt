package sk.upjs.vma.quizapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {

    @Query("SELECT * FROM players")
    fun getAllPlayers() : Flow<List<QuizDB>>

    // insert riesi aj update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quizDB: QuizDB)


}
