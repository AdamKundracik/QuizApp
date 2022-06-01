package sk.upjs.vma.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start = findViewById<Button>(R.id.buttonStart)
        btn_start.setOnClickListener {
            val et_name = findViewById<EditText>(R.id.et_name)
            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CategoriesActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}