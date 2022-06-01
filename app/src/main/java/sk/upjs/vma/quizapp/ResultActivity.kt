package sk.upjs.vma.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val quizViewModel : QuizViewModel by viewModels {
            QuizViewModel.QuizViewModelFactory((application as QuizApplication).repository)
        }

        var user = findViewById<TextView>(R.id.username)

        val username = intent.getStringExtra(Constants.USER_NAME)

        user.text = "$username"

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        var correctQuestions = findViewById<TextView>(R.id.score)
        correctQuestions.text = "Your score is $correctAnswers out of $totalQuestions"

        var buttonFinish = findViewById<Button>(R.id.buttonFinish)
        buttonFinish.setOnClickListener {
            Log.d("tu to ide ", username!!)
                val player = QuizDB(username!!, correctAnswers )
                quizViewModel.insert(player)
            startActivity(Intent(this, MainActivity::class.java))
        }




    }




}