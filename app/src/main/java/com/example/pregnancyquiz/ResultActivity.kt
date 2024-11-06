package com.example.pregnancyquiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.ArrayList

class ResultActivity : AppCompatActivity() {

    override fun onBackPressed() {
        // super.onBackPressed()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var btnHome : Button = findViewById(R.id.btn_home)
        var btnRestart : Button = findViewById(R.id.btn_restart)
        var btnSummary : Button = findViewById(R.id.btn_summary)
        var sp : SharedPreferences = getSharedPreferences(Constants.SP, Context.MODE_PRIVATE)

        var bestScore = intent.getIntExtra(Constants.BEST_SCORE,999)
        var currentScore = intent.getIntExtra(Constants.CURRENT_SCORE,9909)

        var tv_bestScore : TextView = findViewById(R.id.tv_best_score)
        var tv_currentScore : TextView = findViewById(R.id.tv_current_score)

        var mQuestionQuestions = intent.getSerializableExtra("key") as ArrayList<*>
        var mImageQuestions = intent.getSerializableExtra("key2") as ArrayList<*>
        var mAnswerOneQuestions = intent.getSerializableExtra("key3") as ArrayList<*>
        var mAnswerTwoQuestions = intent.getSerializableExtra("key4") as ArrayList<*>
        var mAnswerThreeQuestions = intent.getSerializableExtra("key5") as ArrayList<*>
        var mAnswerFourQuestions = intent.getSerializableExtra("key6") as ArrayList<*>
        var mCorrectAnswerQuestions = intent.getSerializableExtra("key7") as ArrayList<*>
        var mSelectedAnswerQuestions = intent.getSerializableExtra("key8") as ArrayList<*>

        tv_currentScore.text ="Your score is $currentScore out of 34"
        if(bestScore<currentScore){
            bestScore=currentScore
            tv_bestScore.text= "New best score: $bestScore"
        }
        else
            tv_bestScore.text= "Best score: $bestScore"

        var editor : SharedPreferences.Editor = sp.edit()
        editor.putString(Constants.BEST_SCORE,bestScore.toString())
        editor.commit()

        btnRestart.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.BEST_SCORE,bestScore)
            startActivity(intent)
            finish()}

        btnSummary.setOnClickListener {
            val intent3 = Intent(this, SummaryActivity::class.java)
            intent3.putExtra("key", mQuestionQuestions)
            intent3.putExtra("key2", mImageQuestions)
            intent3.putExtra("key3", mAnswerOneQuestions)
            intent3.putExtra("key4", mAnswerTwoQuestions)
            intent3.putExtra("key5", mAnswerThreeQuestions)
            intent3.putExtra("key6", mAnswerFourQuestions)
            intent3.putExtra("key7", mCorrectAnswerQuestions)
            intent3.putExtra("key8", mSelectedAnswerQuestions)
            intent3.putExtra(Constants.BEST_SCORE,bestScore)
            startActivity(intent3)
        }

        btnHome.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
       // intent2.putExtra(Constants.BEST_SCORE,bestScore.toString())
            startActivity(intent2)
            finish()}
    }
}