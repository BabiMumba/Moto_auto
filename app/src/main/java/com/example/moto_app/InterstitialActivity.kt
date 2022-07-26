package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.button.MaterialButton

class InterstitialActivity : AppCompatActivity() {
    private lateinit var intertitialBtn :MaterialButton
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
            RequestConfiguration.Builder().setTestDeviceIds(listOf("TESTE_ID_1","TESTE_ID_N"))
                .build()
        )
        intertitialBtn = findViewById(R.id.show_Inters)
        intertitialBtn.setOnClickListener {

        }

    }
    private fun loadInterstitialAd(){
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this,"",adRequest,
            object :InterstitialAdLoadCallback(){
                override fun equals(other: Any?): Boolean {
                    return super.equals(other)
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                }

                override fun onAdLoaded(p0: InterstitialAd) {
                    super.onAdLoaded(p0)
                    Log.d(TAG, "onAdLoaded: ")
                    mInterstitialAd = p0
                }
            }
        )
    }
}