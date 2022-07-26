package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration

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
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("PLACE_TESTE_DEVICE_ID_1_HERE","PLACE_TESTE_DEVICE_ID_2_HERE"))
                .build()
        )


    }
}