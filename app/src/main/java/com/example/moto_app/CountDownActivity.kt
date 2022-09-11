package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    private var pts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        point.text = "$pts"
        ajoute.setOnClickListener {
            pts++
            point.text = pts.toString()

        }
        publish.setOnClickListener {
            save(pts.toString())
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