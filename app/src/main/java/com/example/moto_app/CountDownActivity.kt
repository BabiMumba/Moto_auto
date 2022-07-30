package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.CountDownTimer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.moto_app.R
import com.example.moto_app.CountDownActivity.CountDownTimerClass

class CountDownActivity : AppCompatActivity() {
    var button: Button? = null
    var textview: TextView? = null
    var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        button = findViewById<View>(R.id.button1) as Button
        textview = findViewById<View>(R.id.textView1) as TextView
        timer = CountDownTimerClass(20000, 1000)
        (timer as CountDownTimerClass).start()
        button!!.setOnClickListener { }
    }

    inner class CountDownTimerClass(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {
            val progress = (millisUntilFinished / 1000).toInt()
            textview!!.text = Integer.toString(progress)
        }

        override fun onFinish() {
            textview!!.text = " Count Down Finish "
        }
    }

    override fun onPause() {
        Toast.makeText(this, "compte a rebours reinitialiser", Toast.LENGTH_SHORT).show()
        super.onPause()
    }

    override fun onRestart() {
        Toast.makeText(this, "compte a recommencer", Toast.LENGTH_SHORT).show()
        super.onRestart()
    }

    override fun onResume() {
        Toast.makeText(this, "on Resume", Toast.LENGTH_SHORT).show()
        super.onResume()
    }

    override fun onDestroy() {
        Toast.makeText(this, "application tuer", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

}