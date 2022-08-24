package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calcul.*
import kotlin.random.Random

class Calcul : AppCompatActivity() {
    private var score = 0
    private var calculatrice = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul)

        val chif1:Int = Random.nextInt(0,100)
        val chif2:Int = Random.nextInt(0,100)
        txt1.text = chif1.toString()
        txt2.text = chif2.toString()
        calculatrice = chif1 + chif2
        verf.setOnClickListener {
            val repos = reponse.text.toString()
            if (repos == calculatrice.toString()){
                score++
                pts.text = score.toString()
            }
            else
            {
                pts.text = "echouer"
                txt1.text = chif1.toString()
                txt2.text = chif2.toString()
                calculatrice = chif1 + chif2

            }
        }
    }

}