package com.example.moto_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moto_app.databinding.ActivityLoginBinding
import com.example.moto_app.databinding.ActivityProfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        binding.countDown.setOnClickListener {
            startActivity(Intent(this,CountDownActivity::class.java))
        }
        binding.pub.setOnClickListener {
            startActivity(Intent(this,Admob::class.java))
        }
        binding.flot.setOnClickListener {
            startActivity(Intent(this,RewardiActivity::class.java))
        }
        binding.down.setOnClickListener {
            startActivity(Intent(this,InterstitialActivity::class.java))
        }

        binding.logout.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            val email = firebaseUser.email
            binding.myname.text = email

        }else{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}