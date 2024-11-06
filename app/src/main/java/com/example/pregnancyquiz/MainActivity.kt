package com.example.pregnancyquiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pregnancyquiz.QuizQuestionsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnStart : Button = findViewById(R.id.button)
        var btnLearn : Button = findViewById(R.id.button_learn)
        var textBestScore : TextView = findViewById(R.id.textView3)
       // var newBestScore : String? = intent.getStringExtra(Constants.BEST_SCORE)
        var sp : SharedPreferences? = getSharedPreferences(Constants.SP, Context.MODE_PRIVATE)
        if (sp != null) {var  newBestScore : String? = sp.getString(Constants.BEST_SCORE,"0")
        textBestScore.text=newBestScore}

        btnStart.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.BEST_SCORE,textBestScore.text.toString().toInt())
            startActivity(intent)
        }
        btnLearn.setOnClickListener {
            val intent2 = Intent(this,LearnActivity::class.java)
            intent2.putExtra(Constants.BEST_SCORE,textBestScore.text.toString().toInt())
            startActivity(intent2)
        }
    }
}