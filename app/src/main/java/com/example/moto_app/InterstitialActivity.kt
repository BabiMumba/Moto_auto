package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.button.MaterialButton

class InterstitialActivity : AppCompatActivity() {

    private lateinit var intertitialBtn :Button
    companion object{
        private const val TAG = "INTERSTITIAL_TAG"
    }

    private  var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial)

        title = "Interstitial"

        MobileAds.initialize(this){
            Log.d(TAG,"oncreate : status $it")
        }

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("c0404e6b-d5c3-4498-89e3-7ae83f90e059","1bda7af6-ef75-48d9-a0d7-2ea9121c42e6"))
                .build()
        )

        loadInterstitialAd()
        intertitialBtn = findViewById(R.id.show_Inters)
        intertitialBtn.setOnClickListener {
            showInterstitialAd()
        }

    }
    private fun loadInterstitialAd(){
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this,resources.getString(R.string.Intertitial_ad_reel),adRequest,
            object :InterstitialAdLoadCallback(){
                override fun equals(other: Any?): Boolean {
                    return super.equals(other)
                }
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d(TAG, "onAdFailedToLoad: ")
                    mInterstitialAd = null
                }
                override fun onAdLoaded(p0: InterstitialAd) {
                    super.onAdLoaded(p0)
                    Log.d(TAG, "onAdLoaded: ")
                    mInterstitialAd = p0
                }
            }
        )
    }
    private fun showInterstitialAd(){
        if (mInterstitialAd != null){
            Log.d(TAG,"showInterstitial: Ad was loaded, we can show")
            mInterstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                    super.onAdClicked()
                    Log.d(TAG, "onAdClicked: ")
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    Log.d(TAG, "onAdDismissedFullScreenContent: ")
                    mInterstitialAd = null
                    toast("ad is closed here")

                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    super.onAdFailedToShowFullScreenContent(adError)
                    Log.d(TAG, "onAdFailedToShowFullScreenContent: ")
                    mInterstitialAd = null
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                    Log.d(TAG, "onAdImpression: ")
                }

                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()
                    Log.d(TAG, "onAdShowedFullScreenContent: ")
                }
            }
            mInterstitialAd!!.show(this)
        }else{
            Log.d(TAG,"showInterstitial: Ad was not loaded cant show")
            toast("Ad was not loaded task e.g start activity")
        }
    }

    private fun toast(message:String){
        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        showInterstitialAd()
        super.onBackPressed()
    }

}

