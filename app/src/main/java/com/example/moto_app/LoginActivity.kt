package com.example.moto_app

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.moto_app.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var mail = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
         progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("loading in...")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        firebaseAuth = FirebaseAuth.getInstance()
        checkuser()
        binding.createCount.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        binding.btnLogin.setOnClickListener {

            validatedate()
        }

    }

    private fun validatedate() {

        mail = binding.mailLogin.text.toString().trim()
        password = binding.passwordLogin.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            binding.mailLogin.setError("mail invalide")
        }
    }

    private fun checkuser() {
        val firebaseuser = firebaseAuth.currentUser
        if (firebaseuser != null){
            startActivity(Intent(this,ProfilActivity::class.java))
            finish()
        }

    }
}