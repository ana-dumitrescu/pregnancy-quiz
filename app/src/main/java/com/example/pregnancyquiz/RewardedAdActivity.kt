package com.example.pregnancyquiz

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import org.w3c.dom.Text
import java.io.Serializable
import java.util.ArrayList


class RewardedAdActivity : AppCompatActivity() {

    private var mRewardedAd: RewardedAd? = null
    private companion object { const val  TAG = "REWARDED_AD_TAG"}

    override fun onBackPressed() {
       // super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewarded_ad)
        val ad_btn : Button = findViewById(R.id.ad_btn)
        var btnResults : Button = findViewById(R.id.btn_results)
        var bestScore = intent.getIntExtra(Constants.BEST_SCORE,999)
        var currentScore = intent.getIntExtra(Constants.CURRENT_SCORE,9909)
       // val textViewTest : TextView = findViewById(R.id.textView9)

        var mQuestionQuestions = intent.getSerializableExtra("key") as ArrayList<*>
        var mImageQuestions = intent.getSerializableExtra("key2") as ArrayList<*>
        var mAnswerOneQuestions = intent.getSerializableExtra("key3") as ArrayList<*>
        var mAnswerTwoQuestions = intent.getSerializableExtra("key4") as ArrayList<*>
        var mAnswerThreeQuestions = intent.getSerializableExtra("key5") as ArrayList<*>
        var mAnswerFourQuestions = intent.getSerializableExtra("key6") as ArrayList<*>
        var mCorrectAnswerQuestions = intent.getSerializableExtra("key7") as ArrayList<*>
        var mSelectedAnswerQuestions = intent.getSerializableExtra("key8") as ArrayList<*>

       // val id  = idList!![0]
       // textViewTest.text=id.toString()

        btnResults.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.BEST_SCORE,bestScore)
            intent.putExtra(Constants.CURRENT_SCORE,currentScore)
            intent.putExtra("key",mQuestionQuestions)
            intent.putExtra("key2", mImageQuestions)
            intent.putExtra("key3", mAnswerOneQuestions)
            intent.putExtra("key4", mAnswerTwoQuestions)
            intent.putExtra("key5", mAnswerThreeQuestions)
            intent.putExtra("key6", mAnswerFourQuestions)
            intent.putExtra("key7", mCorrectAnswerQuestions)
            intent.putExtra("key8", mSelectedAnswerQuestions)
            startActivity(intent)
            finish()}


        MobileAds.initialize(this) {initStatus ->
            Log.d(TAG, "onCreate: $initStatus")
        }

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("TEST_DEVICE_ID"))
                .build()
        )

        fun loadRewardedAd () {

            var adRequest = AdRequest.Builder().build()
            RewardedAd.load(
                this,
                "ca-app-pub-3940256099942544/5224354917",
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.d(TAG, adError?.toString())
                        mRewardedAd = null
                    }

                    override fun onAdLoaded(rewardedAd: RewardedAd) {
                        Log.d(TAG, "Ad was loaded.")
                        mRewardedAd = rewardedAd
                    }
                })
        }

        fun showRewardedAd () {
            if (mRewardedAd != null) {
                mRewardedAd!!.fullScreenContentCallback = object : FullScreenContentCallback(){

                    override fun onAdClicked() {
                        super.onAdClicked()
                        Log.d(TAG,"onAdClicked: ")
                    }

                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        Log.d(TAG,"onAdDismissedFullScreenContent: ")
                        mRewardedAd=null
                        loadRewardedAd()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        super.onAdFailedToShowFullScreenContent(adError)
                        Log.d(TAG,"onAdFailedToShowFullScreenContent: ${adError.message}")
                        mRewardedAd=null
                    }

                    override fun onAdImpression() {
                        super.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                        Log.d(TAG,"onAdShowedFullScreenContent: ")
                    }
                }

                mRewardedAd!!.show(this){
                    Log.d(TAG,"showRewardedAd: ")
                    Toast.makeText(this,"Reward earned!",Toast.LENGTH_SHORT).show()
                    super.onBackPressed()
                }
            }
            else {
                Toast.makeText(this,"Ad wasn't loaded",Toast.LENGTH_SHORT).show()

            }
        }
        loadRewardedAd()

        ad_btn.setOnClickListener {  showRewardedAd()}
    }
}

