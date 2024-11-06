package com.example.pregnancyquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.pregnancyquiz.databinding.ActivitySummaryBinding
import java.util.ArrayList

class SummaryActivity : AppCompatActivity() {lateinit var binding: ActivitySummaryBinding

    private var mCurrentPosition : Int = 1
    private var mSelectedOptionPosition : Int = 0 //we need to know which option was selected
    private var mBestScore : Int? = null

    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var mQuestionQuestions : ArrayList<String>? = null
    private var mImageQuestions : ArrayList<Int>? = null
    private var mAnswerOneQuestions : ArrayList<String>? = null
    private var mAnswerTwoQuestions : ArrayList<String>? = null
    private var mAnswerThreeQuestions : ArrayList<String>? = null
    private var mAnswerFourQuestions : ArrayList<String>? = null
    private var mCorrectAnswerQuestions : ArrayList<Int>? = null
    private var mSelectedAnswerQuestions : ArrayList<Int>? = null


    var btnPrevious : Button? = null
    var btnNext : Button? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    var size = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        binding = ActivitySummaryBinding.inflate(layoutInflater)

        mBestScore = intent.getIntExtra(Constants.BEST_SCORE,0)


        btnPrevious= findViewById(R.id.previous)
        btnNext  = findViewById(R.id.next)
        var startQuiz : Button = findViewById(R.id.startQuiz)

        mQuestionQuestions = intent.getSerializableExtra("key") as ArrayList<String>
        mImageQuestions = intent.getSerializableExtra("key2") as ArrayList<Int>
        mAnswerOneQuestions = intent.getSerializableExtra("key3") as ArrayList<String>
        mAnswerTwoQuestions = intent.getSerializableExtra("key4") as ArrayList<String>
        mAnswerThreeQuestions = intent.getSerializableExtra("key5") as ArrayList<String>
        mAnswerFourQuestions = intent.getSerializableExtra("key6") as ArrayList<String>
        mCorrectAnswerQuestions = intent.getSerializableExtra("key7") as ArrayList<Int>
        mSelectedAnswerQuestions = intent.getSerializableExtra("key8") as ArrayList<Int>

        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.imageView)
        tvOptionOne=findViewById(R.id.tv_option_one)
        tvOptionTwo =findViewById(R.id.tv_option_two)
        tvOptionThree=findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)

        size = mQuestionQuestions?.size!!

        setQuestion()

        btnNext?.setOnClickListener{
            if (mCurrentPosition==size) mCurrentPosition=0

            mCurrentPosition++
            setQuestion()
            binding.scrollView.scrollTo(0,0)
        }

        btnPrevious?.setOnClickListener{
            if (mCurrentPosition==1) mCurrentPosition=size+1

            mCurrentPosition--
            setQuestion()
            binding.scrollView.scrollTo(0,0)
        }

        startQuiz.setOnClickListener{
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.BEST_SCORE,mBestScore)
            startActivity(intent)
        }



    }

    private fun setQuestion() {
        defaultOptionsView()


        ivImage?.setImageResource(mImageQuestions!![mCurrentPosition - 1])
        tvProgress?.text = "$mCurrentPosition/$size"
        tvQuestion?.text = mQuestionQuestions!![mCurrentPosition - 1] //get the actual question of the question object
        tvOptionOne?.text = mAnswerOneQuestions!![mCurrentPosition - 1]
        tvOptionTwo?.text = mAnswerTwoQuestions!![mCurrentPosition - 1]
        tvOptionThree?.text = mAnswerThreeQuestions!![mCurrentPosition - 1]
        tvOptionFour?.text = mAnswerFourQuestions!![mCurrentPosition - 1]

    }

    private fun defaultOptionsView () {
        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.bordertv)
        }
        mSelectedOptionPosition= mSelectedAnswerQuestions!![mCurrentPosition-1]
        var correctAns = mCorrectAnswerQuestions!![mCurrentPosition-1]

        if(mSelectedOptionPosition!=correctAns) answerView(mSelectedOptionPosition,R.drawable.bordertv_wrong)
        answerView(correctAns,R.drawable.bordertv_correct)


    }


    private fun answerView (answer:Int,drawableView:Int){
        when(answer){
            1 -> tvOptionOne?.background= ContextCompat.getDrawable(this,drawableView)
            2 -> tvOptionTwo?.background= ContextCompat.getDrawable(this,drawableView)
            3 -> tvOptionThree?.background= ContextCompat.getDrawable(this,drawableView)
            4 -> tvOptionFour?.background= ContextCompat.getDrawable(this,drawableView)
        }
    }
}