package sk.upjs.vma.quizapp

import androidx.annotation.WorkerThread

class QuizRepository(private val quizDao: QuizDao) {

    val players = quizDao.getAllPlayers()

    @WorkerThread
    suspend fun insert(quizDB: QuizDB) {
        quizDao.insert(quizDB)
    }
    

}