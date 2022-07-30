package com.example.moto_app

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.moto_app.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.login_forme.*

class MoreActivity : AppCompatActivity() {
    private lateinit var backDrop: View
    private lateinit var lytMic: View
    private lateinit var lytCall: View
    private var rotate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_forme)
        
        var creer = findViewById<TextView>(R.id.creat)
        var compte = findViewById<TextView>(R.id.count)
        
        var cc = findViewById<CardView>(R.id.card1)
        var cc2 = findViewById<CardView>(R.id.card2)

        creer.setOnClickListener {
            try {
                card1.visibility = View.VISIBLE
                card2.visibility = View.GONE
                img.visibility = View.GONE

            }catch (e:Exception){
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }

        }
        compte.setOnClickListener {
                             
            try {
                card1.visibility = View.GONE
                card2.visibility = View.VISIBLE
                img.visibility = View.VISIBLE
            }catch (e:Exception){
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }
        }
        enregistre.setOnClickListener {
            Toast.makeText(this, "enregistrement", Toast.LENGTH_SHORT).show()
            
        }
        se_connecter.setOnClickListener {
            Toast.makeText(this, "se connecter", Toast.LENGTH_SHORT).show()
        }

/*
 backDrop = findViewById(R.id.backdrop)
        lytMic = findViewById(R.id.lytmic)
        lytCall = findViewById(R.id.lyt_call)

        val fabMic: FloatingActionButton = findViewById(R.id.fabmic)
        val fabCall: FloatingActionButton = findViewById(R.id.fab_call)
        val fabAdd: FloatingActionButton = findViewById(R.id.fab_add)

        initShowOut(lytMic)
        initShowOut(lytCall)

        backDrop.visibility = View.GONE
        backDrop.visibility = View.GONE

        fabAdd.setOnClickListener { v: View ->
            toggleFabMode(v)
        }
        backDrop.setOnClickListener {
            toggleFabMode(fabAdd)
        }
        fabMic.setOnClickListener {
            Toast.makeText(this, "Voice clicked", Toast.LENGTH_SHORT).show()
        }
        fabCall.setOnClickListener {
            Toast.makeText(this, "Call clicked", Toast.LENGTH_SHORT).show()
        }
    }
    private fun toggleFabMode(v: View) {
        rotate = rotateFab(v, !rotate)
        if (rotate) {
            showIn(lytMic)
            showIn(lytCall)
            backDrop.visibility = View.VISIBLE
        } else {
            showOut(lytMic)
            showOut(lytCall)
            backDrop.visibility = View.GONE
        }
    }

    private fun initShowOut(v: View) {
        v.visibility = View.GONE
        v.translationY = v.height.toFloat()
        v.alpha = 0f
    }

    private fun rotateFab(v: View, rotate: Boolean): Boolean {
        v.animate().setDuration(200)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                }
            })
            .rotation(if (rotate) 135f else 0f)
        return rotate
    }

    private fun showIn(v: View) {
        v.visibility = View.VISIBLE
        v.alpha = 0f
        v.translationY = v.height.toFloat()
        v.animate()
            .setDuration(200)
            .translationY(0f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                }
            })
            .alpha(1f)
            .start()
    }

    private fun showOut(v: View) {
        v.visibility = View.VISIBLE
        v.alpha = 1f
        v.translationY = 0f
        v.animate()
            .setDuration(200)
            .translationY(v.height.toFloat())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    v.visibility = View.GONE
                    super.onAnimationEnd(animation)
                }
            }).alpha(0f)
            .start()
 */

    }
}