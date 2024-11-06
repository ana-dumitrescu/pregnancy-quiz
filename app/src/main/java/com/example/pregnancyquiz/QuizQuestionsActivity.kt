package com.example.pregnancyquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.pregnancyquiz.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    override fun onBackPressed() {
        // super.onBackPressed()
    }

    lateinit var binding: ActivityQuizQuestionsBinding

    private var mCurrentPosition : Int = 1
    private var mQuestionList:ArrayList<Question>?=null //we can only assign it inside the onCreate method
    private var mSelectedOptionPosition : Int = 0 //we need to know which option was selected
    private var mBestScore : Int? = null

    private var mQuestionQuestions : ArrayList<String>? = null
    private var mImageQuestions : ArrayList<Int>? = null
    private var mAnswerOneQuestions : ArrayList<String>? = null
    private var mAnswerTwoQuestions : ArrayList<String>? = null
    private var mAnswerThreeQuestions : ArrayList<String>? = null
    private var mAnswerFourQuestions : ArrayList<String>? = null
    private var mCorrectAnswerQuestions : ArrayList<Int>? = null
    private var mSelectedAnswerQuestions : ArrayList<Int>? = null

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null
    var a = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)

        mBestScore = intent.getIntExtra(Constants.BEST_SCORE,0)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.imageView)
        tvOptionOne=findViewById(R.id.tv_option_one)
        tvOptionTwo =findViewById(R.id.tv_option_two)
        tvOptionThree=findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        mQuestionQuestions = ArrayList()
        mImageQuestions = ArrayList()
        mAnswerOneQuestions = ArrayList()
        mAnswerTwoQuestions = ArrayList()
        mAnswerThreeQuestions = ArrayList()
        mAnswerFourQuestions = ArrayList()
        mCorrectAnswerQuestions = ArrayList()
        mSelectedAnswerQuestions = ArrayList()

        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionsView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        //"!!" because we are sure is not null at this point

        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question //get the actual question of the question object
        tvOptionOne?.text = question.answerOne
        tvOptionTwo?.text = question.answerTwo
        tvOptionThree?.text = question.answerThree
        tvOptionFour?.text = question.answerFour

        mQuestionQuestions?.add(question.question)
        mImageQuestions?.add(question.image)
        mAnswerOneQuestions?.add(question.answerOne)
        mAnswerTwoQuestions?.add(question.answerTwo)
        mAnswerThreeQuestions?.add(question.answerThree)
        mAnswerFourQuestions?.add(question.answerFour)
        mCorrectAnswerQuestions?.add(question.correctAnswer)

    }

    private fun defaultOptionsView () {
        btnSubmit?.text="SUBMIT"
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
    }

    private fun selectedOptionView (tv:TextView,selectedOptionNum:Int) {

        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.bordertv_purple)
    }


    override fun onClick(view: View?) {
        when (view?.id){
            R.id.tv_option_one ->  {tvOptionOne?.let{
                selectedOptionView(it,1)
            }}
            R.id.tv_option_two ->  {tvOptionTwo?.let{
                selectedOptionView(it,2)
            }}
            R.id.tv_option_three ->  {tvOptionThree?.let{
                selectedOptionView(it,3)
            }}
            R.id.tv_option_four ->  {tvOptionFour?.let{
                selectedOptionView(it,4)
            }}
            R.id.btn_submit -> {btnSubmit?.let{
                if (mSelectedOptionPosition==0){ mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionList!!.size && btnSubmit?.text!="SUBMIT"-> {setQuestion()
                            binding.scrollView.scrollTo(0,0)}
                        mCurrentPosition<=mQuestionList!!.size && btnSubmit?.text=="SUBMIT"-> {Toast.makeText(this,"Please select an answer.",Toast.LENGTH_LONG).show()}
                        else ->{val intent =Intent(this, ResultActivity::class.java)
                            intent.putExtra("key", mQuestionQuestions)
                            intent.putExtra("key2", mImageQuestions)
                            intent.putExtra("key3", mAnswerOneQuestions)
                            intent.putExtra("key4", mAnswerTwoQuestions)
                            intent.putExtra("key5", mAnswerThreeQuestions)
                            intent.putExtra("key6", mAnswerFourQuestions)
                            intent.putExtra("key7", mCorrectAnswerQuestions)
                            intent.putExtra("key8", mSelectedAnswerQuestions)
                            intent.putExtra(Constants.BEST_SCORE,mBestScore)
                            intent.putExtra(Constants.CURRENT_SCORE,mCurrentPosition)
                            startActivity(intent)
                            finish()}

                    }
                }
                else {
                    mSelectedAnswerQuestions?.add(mSelectedOptionPosition)
                    val question = mQuestionList?.get(mCurrentPosition-1)


                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.bordertv_wrong)
                        if(a==0){
                            a++
                            val intent2 =Intent(this, RewardedAdActivity::class.java)
                            intent2.putExtra("key", mQuestionQuestions)
                            intent2.putExtra("key2", mImageQuestions)
                            intent2.putExtra("key3", mAnswerOneQuestions)
                            intent2.putExtra("key4", mAnswerTwoQuestions)
                            intent2.putExtra("key5", mAnswerThreeQuestions)
                            intent2.putExtra("key6", mAnswerFourQuestions)
                            intent2.putExtra("key7", mCorrectAnswerQuestions)
                            intent2.putExtra("key8", mSelectedAnswerQuestions)
                            intent2.putExtra(Constants.BEST_SCORE,mBestScore)
                            intent2.putExtra(Constants.CURRENT_SCORE,mCurrentPosition-1)
                             startActivity(intent2)}
                        else {
                            val intent3 =Intent(this, ResultActivity::class.java)
                            intent3.putExtra("key", mQuestionQuestions)
                            intent3.putExtra("key2", mImageQuestions)
                            intent3.putExtra("key3", mAnswerOneQuestions)
                            intent3.putExtra("key4", mAnswerTwoQuestions)
                            intent3.putExtra("key5", mAnswerThreeQuestions)
                            intent3.putExtra("key6", mAnswerFourQuestions)
                            intent3.putExtra("key7", mCorrectAnswerQuestions)
                            intent3.putExtra("key8", mSelectedAnswerQuestions)
                            intent3.putExtra(Constants.BEST_SCORE,mBestScore)
                            intent3.putExtra(Constants.CURRENT_SCORE,mCurrentPosition-1)
                            startActivity(intent3)
                            finish()
                        }

                    }
                    answerView(question.correctAnswer,R.drawable.bordertv_correct)
                }


                if(mCurrentPosition == mQuestionList!!.size) btnSubmit?.text= "FINISH"
              //  else if(tvOptionOne?.background ==ContextCompat.getDrawable(this,R.drawable.bordertv_correct)  || tvOptionTwo?.background==ContextCompat.getDrawable(this,R.drawable.bordertv_correct)  || tvOptionThree?.background==ContextCompat.getDrawable(this,R.drawable.bordertv_correct)  || tvOptionFour?.background==ContextCompat.getDrawable(this,R.drawable.bordertv_correct))
               else if (mSelectedOptionPosition==0)
                      btnSubmit?.text="SUBMIT"
                else btnSubmit?.text="GO TO NEXT QUESTION"



                mSelectedOptionPosition =0
                
            }}
        }
    }

    private fun answerView (answer:Int,drawableView:Int){
        when(answer){
            1 -> tvOptionOne?.background=ContextCompat.getDrawable(this,drawableView)
            2 -> tvOptionTwo?.background=ContextCompat.getDrawable(this,drawableView)
            3 -> tvOptionThree?.background=ContextCompat.getDrawable(this,drawableView)
            4 -> tvOptionFour?.background=ContextCompat.getDrawable(this,drawableView)
        }
    }
}