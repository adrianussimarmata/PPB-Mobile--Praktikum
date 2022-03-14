package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LihatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String task[], deadline[], note[], create[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        recyclerView = findViewById(R.id.recyclerView);

        task = getResources().getStringArray(R.array.list_task);
        deadline = getResources().getStringArray(R.array.list_deadline);
        note = getResources().getStringArray(R.array.list_catatan);
        create = getResources().getStringArray(R.array.list_tglCreate);

        MyAdapter myAdapter = new MyAdapter(this, task, deadline, create);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}