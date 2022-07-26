package com.example.moto_app

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    private var pts = 0
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        firebaseAuth = FirebaseAuth.getInstance()
        //recuperer le document

        read()
        /*
        point.text = "$pts"
        ajoute.setOnClickListener {
            pts++
            point.text = pts.toString()

        }
         */

        publish.setOnClickListener {

        }
        update.setOnClickListener {
            val firebaseUser = firebaseAuth.currentUser
            if (firebaseUser != null){
                val email = firebaseUser.email.toString()
                ajour(email)
            }else{
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
        }

    }

    fun save(nb:String){
        val db = FirebaseFirestore.getInstance()
        val point:MutableMap<String , Any> = HashMap()
        point["pts"] = nb
        db.collection("point")
            .document("nb_point")
            .set(point)
            .addOnSuccessListener {
                Toast.makeText(this, "nombre ajouter", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show()
            }
    }

    fun ajour(nom:String){
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter...")
        progressDialog.setMessage("chargement Encours...")
        progressDialog.show()
        val db = FirebaseFirestore.getInstance()
        var noms = nom.replaceAfter("@","")
        val nombre = db.collection("point").document(noms)
        nombre.update("Point",FieldValue.increment(1))
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Document mis ajours", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Erreur de chargement ", Toast.LENGTH_SHORT).show()
            }
        read()
    }
    fun read(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter...")
        progressDialog.setMessage("chargement Encours...")
        progressDialog.show()

        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            val email = firebaseUser.email.toString()
            var nom = email.replaceAfter("@","")
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("point").document(nom)
            docRef.get()
                .addOnSuccessListener { document ->
                    progressDialog.dismiss()
                    if (document != null) {
                        rd.text = document.data?.getValue("Point").toString()

                        Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    } else {
                        Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    progressDialog.dismiss()
                    //Log.d(TAG, "get failed with ", exception)
                }
        }else{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    fun rrdead(){
        val db = FirebaseFirestore.getInstance()
        db.collection("point")
            .whereEqualTo("pts",true)
            .get()
            .addOnCompleteListener {
                val resul = StringBuffer()
                if (it.isSuccessful){
                    for (document in it.result){
                        resul.append(document.data.getValue("pts"))
                    }
                    rd.text = resul
                }
            }

    }

   }