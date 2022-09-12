package com.example.moto_app

import android.app.ProgressDialog
import android.content.ContentValues
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_count_down.*
import kotlinx.android.synthetic.main.activity_rewardi.*

class RewardiActivity : AppCompatActivity() {


    private companion object{
        private const val TAG = "REWARDED_INTER_TAG"
    }
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var showbtn : Button
    private lateinit var loadAndShow : Button
    private var mRewardedInterstitialAd : RewardedInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewardi)
        firebaseAuth = FirebaseAuth.getInstance()

        read()
        showbtn = findViewById(R.id.showAdbtn)
        loadAndShow = findViewById(R.id.LoadAdbtn)

        MobileAds.initialize(this){
            Log.d(TAG,"Oncreate:")
        }
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("e3ecfe91-a277-4650-92e0-4f0cf2ad9c13","e4daca5f-a422-4831-b688-7b0b0d1da7cc"))
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
            //AdRequest adRequest = new AdRequest.Builder().addTestDevice("94DF0193F80DB5F14BFF0EA958D02BC9").build();
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
                    Toast.makeText(this@RewardiActivity, "video pret", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(this@RewardiActivity, "vous avez cliquez sur la pub", Toast.LENGTH_SHORT).show()

                    }
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        Toast.makeText(this@RewardiActivity, "Vous avez fermer ", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(this@RewardiActivity, "pub valider", Toast.LENGTH_SHORT).show()
                        Log.d(TAG,"onAdImpression: ")
                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                        Log.d(TAG,"onAdShowFullScreencontente: ")

                    }

                }
            mRewardedInterstitialAd!!.show(this){
                ajouter()
                Toast.makeText(this, "recompence accorder", Toast.LENGTH_SHORT).show()
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
        progressDialog.setTitle("Patienter...")
        progressDialog.setMessage("chargement de la video...")
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
                    Toast.makeText(this@RewardiActivity, "Video pret", Toast.LENGTH_SHORT).show()
                    mRewardedInterstitialAd = rewardedInterstitialAd
                    progressDialog.dismiss()
                    showRewardedInters()
                }
            }

        )

    }
    fun read(){
        val firebaseUser = firebaseAuth.currentUser
        val email = firebaseUser?.email.toString()
        var nom = email.replaceAfter("@","")
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter...")
        progressDialog.setMessage("chargement Encours...")
        progressDialog.show()
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("point").document(nom)
        docRef.get()
            .addOnSuccessListener { document ->
                progressDialog.dismiss()
                if (document != null) {
                    pts_rd.text = document.data?.getValue("point").toString()
                    Log.d(ContentValues.TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(ContentValues.TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                progressDialog.dismiss()
                Log.d(ContentValues.TAG, "get failed with ", exception)
            }

    }
    fun ajouter(){
        val firebaseUser = firebaseAuth.currentUser
        val email = firebaseUser?.email.toString()
        var nom = email.replaceAfter("@","")
        val db = FirebaseFirestore.getInstance()
        val nombre = db.collection("point").document(nom)
        nombre.update("point", FieldValue.increment(5))
            .addOnSuccessListener {
                Toast.makeText(this, "Document mis ajours", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erreur de chargement ", Toast.LENGTH_SHORT).show()

            }
        read()
    }
}