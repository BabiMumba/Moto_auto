package com.example.moto_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setAdapter(recyclerView);
    }

    private void setAdapter(RecyclerView recyclerView) {
        List<ModelPerson> modelPersonList = new ArrayList<>();
        AdapterPerson adapterPerson = new AdapterPerson(modelPersonList, this);

        recyclerView.setAdapter(adapterPerson);
        ModelPerson person = new ModelPerson("Mario Speedwagon", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Petey Cruiser", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Anna Sthesia", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Paul Molive", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Anna Mull", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Gail Forcewind", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Paige Turner", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Bob Frapples", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
        person = new ModelPerson("Walter Melon", "abc@email.com", R.mipmap.ic_launcher);
        modelPersonList.add(person);
    }
}