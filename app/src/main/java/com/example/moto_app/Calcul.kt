package com.example.moto_app

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calcul.*
import kotlin.random.Random

class Calcul : AppCompatActivity() {
    private var score = 0
    private var calculatrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul)


        loadData()
        teste()

        verf.setOnClickListener {

            val repos = reponse.text.toString()
            if (repos == calculatrice.toString()){
                score++
                pts.text = score.toString()
                teste()
                reponse.setText("")
                savedata()
            }
            else
            {
                pts.text = score--.toString()
                teste()
                reponse.setText("")
                savedata()

            }
        }
    }
    private fun teste(){
        val chif1:Int = Random.nextInt(0,100)
        val chif2:Int = Random.nextInt(0,100)
        txt1.text = chif1.toString()
        txt2.text = chif2.toString()
        calculatrice = chif1 + chif2

    }
    private fun savedata(){
        val inserText:String = pts.text.toString()
        val sharedPreferences:SharedPreferences = getSharedPreferences("sharedPefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY",inserText)
        }.apply()
        Toast.makeText(this, "score sauvegarder", Toast.LENGTH_SHORT).show()
    }
    private fun loadData(){
        val sharedPreferences:SharedPreferences = getSharedPreferences("sharedPefs",Context.MODE_PRIVATE)
        val savestring = sharedPreferences.getString("STRING_KEY",null)
        pts.text = savestring
    }

}