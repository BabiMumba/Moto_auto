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

        shared = getSharedPreferences("test", Context.MODE_PRIVATE)

        button = findViewById<View>(R.id.button1) as Button
        textview = findViewById<View>(R.id.textView1) as TextView

        txt_point.text = shared.getString("txt","no imported")

        button!!.setOnClickListener {
            timer = CountDownTimerClass(10000, 1000)
            (timer as CountDownTimerClass).start()
        }
    }

    inner class CountDownTimerClass(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {
            val progress = (millisUntilFinished / 1000).toInt()
            textview!!.text = Integer.toString(progress)
        }
        override fun onFinish() {
            var point = 0
            var bonus = point+1
            val edit = shared.edit()
            edit.putString("txt", "$bonus")
            Toast.makeText(this@CountDownActivity, "was saved", Toast.LENGTH_SHORT).show()
            edit.apply()
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