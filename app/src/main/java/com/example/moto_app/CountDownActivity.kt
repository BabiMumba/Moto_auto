package com.example.moto_app

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    private var pts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)



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
            save(pts.toString())
        }
        update.setOnClickListener {
            ajour()
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
    fun ajour(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter...")
        progressDialog.setMessage("chargement Encours...")
        progressDialog.show()

        val db = FirebaseFirestore.getInstance()
        val nombre = db.collection("point").document("nb_point")
        nombre.update("pts",FieldValue.increment(1))
            .addOnSuccessListener {
                super.onResume()
                progressDialog.dismiss()
                Toast.makeText(this, "Document mis ajours", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                super.onResume()
                progressDialog.dismiss()
                Toast.makeText(this, "mis ajour ", Toast.LENGTH_SHORT).show()

            }
        read()
    }
    fun read(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter...")
        progressDialog.setMessage("chargement Encours...")
        progressDialog.show()
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("point").document("nb_point")
        docRef.get()

            .addOnSuccessListener { document ->
                super.onResume()
                progressDialog.dismiss()
                if (document != null) {
                    rd.text = document.data?.getValue("pts").toString()
                    println(document.data?.getValue("pts"))
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                super.onResume()
                progressDialog.dismiss()
                Log.d(TAG, "get failed with ", exception)
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