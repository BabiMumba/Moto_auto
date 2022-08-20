package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.*

class Admob : AppCompatActivity() {
    private companion object{
        private const val TAG = "BANNER_AD_TAG"
    }
    private var adview:AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admob)
        MobileAds.initialize(this){
            Log.d(TAG,"inias complet")
        }

        adview = findViewById(R.id.bannerAd)
        val adRequest = AdRequest.Builder().build()
        //load ad
        adview?.loadAd(adRequest)
        //setup ad callback listener

        adview?.adListener = object : AdListener(){
            override fun onAdClicked() {
                super.onAdClicked()
                Log.d(TAG, "onAdClicked: ")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.d(TAG, "onAdClosed: ")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d(TAG, "onAdFailedToLoad: $p0")
            }

            override fun onAdImpression() {
                super.onAdImpression()
                Log.d(TAG, "onAdImpression: ")
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d(TAG, "onAdLoaded: ")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Log.d(TAG, "onAdOpened: ")
            }
        }
    }

    override fun onPause() {
        adview?.pause()
        super.onPause()
        Log.d(TAG, "onPause: ")

    }
    override fun onResume() {
        adview?.resume()
        super.onResume()
        Log.d(TAG, "onResume: ")
    }
    override fun onDestroy() {
        adview?.destroy()
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}