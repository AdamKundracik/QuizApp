package sk.upjs.vma.quizapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class QuizViewModel(val repository: QuizRepository): ViewModel() {

    val players = repository.players.asLiveData()

    fun insert(quizDB: QuizDB) {
        viewModelScope.launch {
            repository.insert(quizDB)
        }
    }

    class QuizViewModelFactory(private val repository: QuizRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
                return QuizViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }

}