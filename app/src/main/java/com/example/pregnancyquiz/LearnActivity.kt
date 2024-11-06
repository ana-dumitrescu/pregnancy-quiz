package com.example.pregnancyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import com.example.pregnancyquiz.databinding.ActivitySummaryBinding

class LearnActivity : AppCompatActivity() { lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        var questionList : ArrayList<Question>? = null
        var tvQuestion : TextView? = null
        var tvAnswer : TextView? = null
        var tvSources : TextView? = null
        var currentPosition : Int = 1
        var btnPrevious : Button? = null
        var btnNext : Button? = null


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)

        binding = ActivitySummaryBinding.inflate(layoutInflater)

        questionList = Constants.getQuestions()
         tvQuestion  = findViewById(R.id.q)
         tvAnswer = findViewById(R.id.answ)
         tvSources = findViewById(R.id.source)
         btnPrevious= findViewById(R.id.previous)
        btnNext  = findViewById(R.id.next)
        var startQuiz : Button = findViewById(R.id.startQuiz)
        var bestScore = intent.getIntExtra(Constants.BEST_SCORE,0)

        tvSources.movementMethod = ScrollingMovementMethod()

        var question:Question=questionList[currentPosition-1]

        tvQuestion.text=question.question

        if(question.correctAnswer==1)
        tvAnswer.text=question.answerOne
        else if(question.correctAnswer==2) tvAnswer.text=question.answerTwo
        else if(question.correctAnswer==3) tvAnswer.text=question.answerThree
        else if(question.correctAnswer==4) tvAnswer.text=question.answerFour

        tvSources.text = question.source

        btnNext.setOnClickListener{
            tvSources.scrollTo(0,0)
            if (currentPosition==34) currentPosition=0

            currentPosition++
            question = questionList[currentPosition-1]
            tvQuestion.text=question.question

            if(question.correctAnswer==1)
                tvAnswer.text=question.answerOne
            else if(question.correctAnswer==2) tvAnswer.text=question.answerTwo
            else if(question.correctAnswer==3) tvAnswer.text=question.answerThree
            else if(question.correctAnswer==4) tvAnswer.text=question.answerFour

            tvSources.text = question.source
            binding.scrollView.scrollTo(0,0)
        }

        startQuiz.setOnClickListener{
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.BEST_SCORE,bestScore)
            startActivity(intent)
        }

        btnPrevious.setOnClickListener{
            tvSources.scrollTo(0,0)
            if (currentPosition==1) currentPosition=35

            currentPosition--
            question = questionList[currentPosition-1]
            tvQuestion.text=question.question

            if(question.correctAnswer==1)
                tvAnswer.text=question.answerOne
            else if(question.correctAnswer==2) tvAnswer.text=question.answerTwo
            else if(question.correctAnswer==3) tvAnswer.text=question.answerThree
            else if(question.correctAnswer==4) tvAnswer.text=question.answerFour

            tvSources.text = question.source
            binding.scrollView.scrollTo(0,0)
        }
    }
}