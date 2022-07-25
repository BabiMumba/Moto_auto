package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moto_app.R

class FloatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating)

        bottomAppBar.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.search -> Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT)
                    .show()
                R.id.more -> Toast.makeText(this, "More Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
            false
        }

        findViewById<View>(R.id.fab).setOnClickListener {
            Toast.makeText(this, "Fab Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}