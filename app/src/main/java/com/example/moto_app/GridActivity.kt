package com.example.moto_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moto_app.R
import androidx.recyclerview.widget.RecyclerView
import com.example.moto_app.ModelPerson
import com.example.moto_app.AdapterPerson
import java.util.ArrayList

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        setAdapter(recyclerView)
    }

    private fun setAdapter(recyclerView: RecyclerView) {
        val modelPersonList: MutableList<ModelPerson> = ArrayList()
        val adapterPerson = AdapterPerson(modelPersonList, this)
        recyclerView.adapter = adapterPerson
        var person = ModelPerson("Mario Speedwagon", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Petey Cruiser", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Anna Sthesia", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Paul Molive", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Anna Mull", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Gail Forcewind", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Paige Turner", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Bob Frapples", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.mipmap.ic_launcher)
        modelPersonList.add(person)
    }
}