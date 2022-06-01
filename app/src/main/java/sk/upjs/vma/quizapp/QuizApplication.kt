package sk.upjs.vma.quizapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class QuizApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {QuizDatabase.getDatabase(this, applicationScope)}
    val repository by lazy { QuizRepository(database.quizDao()) }
}