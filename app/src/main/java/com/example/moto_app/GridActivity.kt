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

        var person = ModelPerson("Mario Speedwagon", "abc@email.com", R.drawable.dissatisfaction)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.eng)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.math_pi)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.math_pi)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.innovation)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.other_book)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.religion)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.codage)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.statistics)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.codage)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.eng)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.fina2)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.function)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.handshake)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.heart)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.math_pi)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.innovation)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.other_book)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.religion)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.codage)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.statistics)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.codage)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.eng)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.fina2)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.function)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.handshake)
        modelPersonList.add(person)
        person = ModelPerson("Walter Melon", "abc@email.com", R.drawable.heart)
        modelPersonList.add(person)

    }
}