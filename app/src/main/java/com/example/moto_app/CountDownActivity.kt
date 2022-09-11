package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    var pts = 34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        pts.toString()

        point.text = "$pts"
        ajoute.setOnClickListener {
        pts++
        }
    }

    fun save(nb:String){
        val db = FirebaseFirestore.getInstance()
        val point:MutableMap<String , Any> = HashMap()
        point["12"] = nb
        db.collection("point")
            .add(point)
            .addOnSuccessListener {
                Toast.makeText(this, "nombre ajouter", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show()
            }


    }
   }