package sk.upjs.vma.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var questionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnwers: Int = 0
    private var mUserName: String? = null
    private var selectedQuestion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        selectedQuestion = intent.getStringExtra(Constants.SELECTED_QUESTION)
        println(selectedQuestion)

        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)
        val buttonSubmit = findViewById<Button>(R.id.submitButton)

        if(selectedQuestion.equals("1")) {
            questionList = QuestionConstants.getHistoryQuestions()
        }
        if(selectedQuestion.equals("2")) {
            questionList = QuestionConstants.getMathsQuestions()
        }
        if(selectedQuestion.equals("3")) {
            questionList = QuestionConstants.getSportsQuestions()
        }
        if(selectedQuestion.equals("4")) {
            questionList = QuestionConstants.getMusicQuestions()
        }

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        buttonSubmit.setOnClickListener(this)



     }

    private fun setQuestion() {

        val buttonSubmit = findViewById<Button>(R.id.submitButton)
        val question = questionList!![mCurrentPosition-1]

        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        progressBar.progress = mCurrentPosition

        defaultOptionsView()
        if(mCurrentPosition == questionList!!.size) {
            buttonSubmit.text = "Finish"
        } else {
            buttonSubmit.text = "Submit"
        }

        val progressBarStatus = findViewById<TextView>(R.id.progressbar_progress)
        progressBarStatus.text = "$mCurrentPosition" + "/" + progressBar.max

        val questionField = findViewById<TextView>(R.id.question)
        questionField.text = question!!.question

        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)

        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour

    }

    private fun defaultOptionsView() {

        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)

        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {

        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)
        val buttonSubmit = findViewById<Button>(R.id.submitButton)

        when(v?.id) {

            R.id.option_one -> {
                selectedOptionView(optionOne,1)
            }
            R.id.option_two -> {
                selectedOptionView(optionTwo,2)
            }
            R.id.option_three -> {
                selectedOptionView(optionThree,3)
            }
            R.id.option_four -> {
                selectedOptionView(optionFour,4)
            }
            R.id.submitButton -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= questionList!!.size -> {
                            setQuestion()
                        } else -> {
                            Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this,ResultActivity::class.java )
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnwers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = questionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnwers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == questionList?.size) {
                        buttonSubmit.text = "Finish"
                    } else {
                        buttonSubmit.text = "Go to next question"

                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val optionOne = findViewById<TextView>(R.id.option_one)
        val optionTwo = findViewById<TextView>(R.id.option_two)
        val optionThree = findViewById<TextView>(R.id.option_three)
        val optionFour = findViewById<TextView>(R.id.option_four)

        when(answer) {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}