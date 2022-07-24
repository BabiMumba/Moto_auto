package com.example.moto_app

import android.app.ProgressDialog
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.moto_app.databinding.ActivityLoginBinding
import com.example.moto_app.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var mail = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("creation du compte")
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            valideteData()
        }
    }

    private fun valideteData() {
        mail = binding.mailRegister.text.toString().trim()
        password = binding.passwordRegister.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            binding.mailRegister.error = "mail invalide"
        }else if (TextUtils.isEmpty(password)){
            binding.passwordRegister.error= "entrer votre mot de passe"
        }else{
            firebaseSignUp()
        }


    }

    private fun firebaseSignUp() {
        progressDialog.show()
        firebaseAuth.createUserWithEmailAndPassword(mail,password)
            .addOnSuccessListener {
                progressDialog.dismiss()

                val firebaseuser = firebaseAuth.currentUser
                val mail = firebaseuser!!.email
                Toast.makeText(this, "compte creer avec succer", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,ProfilActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                progressDialog.dismiss()
                Toast.makeText(this, "compte creer avec succer", Toast.LENGTH_SHORT).show()

            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}