package com.example.moto_app

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
import kotlinx.android.synthetic.main.activity_rewardi.*

class RewardiActivity : AppCompatActivity() {
    private companion object{
        private const val TAG = "REWARDED_INTER_TAG"
    }
    private lateinit var showbtn : Button
    private lateinit var loadAndShow : Button

    private var mRewardedInterstitialAd : RewardedInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewardi)
        showbtn = findViewById(R.id.showAdbtn)
        loadAndShow = findViewById(R.id.LoadAdbtn)

        MobileAds.initialize(this){
            Log.d(TAG,"Oncreate:")

        }
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("TESTE_DEVICE_ID_1","TEST_DEVICE_ID_2","TEST_DEVICE_ID_N"))
                .build()
        )
        loadrewardedInters()

        loadAndShow.setOnClickListener{
            loadAndShowRewarded()


        }

        showbtn.setOnClickListener {
            showRewardedInters()

        }


    }

    private fun loadrewardedInters() {

        RewardedInterstitialAd.load(
            this,
            resources.getString(R.string.rewarded_ad_reel),
            AdRequest.Builder().build(),
            object : RewardedInterstitialAdLoadCallback(){
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                    Log.d(TAG,"chargement echouer:${loadAdError.message}")
                    mRewardedInterstitialAd = null
                }

                override fun onAdLoaded(rewardedInterstitialAd: RewardedInterstitialAd) {
                    super.onAdLoaded(rewardedInterstitialAd)

                    Log.d(TAG,"OnLoaded")
                    mRewardedInterstitialAd = rewardedInterstitialAd
                }
            }

        )
    }
    private fun showRewardedInters(){

        if (mRewardedInterstitialAd != null){
            Log.d(TAG,"showRewarded")
            mRewardedInterstitialAd!!.fullScreenContentCallback =
                object: FullScreenContentCallback(){
                    override fun onAdClicked() {
                        super.onAdClicked()

                        Log.d(TAG,"onAdclicked")

                    }

                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()

                        Log.d(TAG,"onAddismissFullScreen: ")

                        mRewardedInterstitialAd = null
                        loadrewardedInters()

                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        super.onAdFailedToShowFullScreenContent(adError)
                        Log.d(TAG,"onAdfailedtoShowFullscreen: ${adError.message} ")
                        mRewardedInterstitialAd = null
                    }

                    override fun onAdImpression() {
                        super.onAdImpression()
                        Log.d(TAG,"onAdImpression: ")
                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                        Log.d(TAG,"onAdShowFullScreencontente: ")
                    }
                }
            mRewardedInterstitialAd!!.show(this){
                Toast.makeText(this, "Rewarded earned... !", Toast.LENGTH_SHORT).show()
                Log.d(TAG,"onUserEarnedrewarded: ")
            }

        }
        else{
            Log.d(TAG,"chargement echouer")
            Toast.makeText(this, "chergement echouer", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadAndShowRewarded(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("please")
        progressDialog.setMessage("loading Rewarded Inters...")
        progressDialog.show()

        RewardedInterstitialAd.load(
            this,
            resources.getString(R.string.rewarded_ad_reel),
            AdRequest.Builder().build(),
            object : RewardedInterstitialAdLoadCallback(){
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                    Log.d(TAG,"chargement echouer:${loadAdError.message}")
                    mRewardedInterstitialAd = null
                    progressDialog.dismiss()
                    Toast.makeText(this@RewardiActivity, "ad was not loaded", Toast.LENGTH_SHORT).show()

                }

                override fun onAdLoaded(rewardedInterstitialAd: RewardedInterstitialAd) {
                    super.onAdLoaded(rewardedInterstitialAd)

                    Log.d(TAG,"OnLoaded")
                    mRewardedInterstitialAd = rewardedInterstitialAd
                    progressDialog.dismiss()
                    showRewardedInters()
                }
            }

        )

    }
}