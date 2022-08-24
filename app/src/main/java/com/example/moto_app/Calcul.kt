package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calcul.*
import kotlin.random.Random

class Calcul : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul)

        val chif1 = Random.nextInt(0,100)
        val chif2 = Random.nextInt(0,100)
        val resulta = chif1+chif2
        verf.setOnClickListener {
            val repos =
        }
    }
}