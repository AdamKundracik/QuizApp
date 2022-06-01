package sk.upjs.vma.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoriesActivity : AppCompatActivity() {
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        val sportsButton = findViewById<Button>(R.id.sports)
        val historyButton = findViewById<Button>(R.id.history)
        val mathsButton = findViewById<Button>(R.id.maths)
        val musicButton = findViewById<Button>(R.id.music)

        historyButton.setOnClickListener {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, mUserName)
                intent.putExtra(Constants.SELECTED_QUESTION, "1")
                startActivity(intent)
                finish()
            }

        mathsButton.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, mUserName)
            intent.putExtra(Constants.SELECTED_QUESTION, "2")
            startActivity(intent)
            finish()
        }

        sportsButton.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, mUserName)
            intent.putExtra(Constants.SELECTED_QUESTION, "3")
            startActivity(intent)
            finish()
        }
        musicButton.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, mUserName)
            intent.putExtra(Constants.SELECTED_QUESTION, "4")
            startActivity(intent)
            finish()
        }
    }
}