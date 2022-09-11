package com.example.moto_app

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.CountDownTimer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.moto_app.R
import com.example.moto_app.CountDownActivity.CountDownTimerClass
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {
    var button: Button? = null
    var textview: TextView? = null
    var timer: CountDownTimer? = null
    lateinit var shared: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

    }
   }