package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class PubActivity : AppCompatActivity() {
    lateinit var adView: AdView
    lateinit var adRequest: AdRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pub)

        MobileAds.initialize(this)

        // on below line we are initializing
        // our ad view with its id
        adView = findViewById(R.id.adView)

        // on below line we are
        // initializing our ad request.
        adRequest = AdRequest.Builder().build()

        // on below line we are loading our
        // ad view with the ad request
        adView.loadAd(adRequest)

    }
}