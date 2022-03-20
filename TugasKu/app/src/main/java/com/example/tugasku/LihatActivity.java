package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class LihatActivity extends AppCompatActivity {

    // LiveData
    TugasViewModel tugasViewModel;

    TugasAdapter tugasAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        tugasViewModel = new ViewModelProvider(this).get(TugasViewModel.class);
        tugasAdapter = new TugasAdapter();
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tugasViewModel.getAllTugas().observe(this, new Observer<List<Tugas>>() {
            @Override
            public void onChanged(List<Tugas> tugases) {
                if (tugases.size() > 0) {
                    tugasAdapter.setData(tugases);
                    recyclerView.setAdapter(tugasAdapter);
                }
            }
        });
    }

    // Data Dummy
//    RecyclerView recyclerView;
//    String task[], deadline[], note[], create[];
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lihat);
//
//        recyclerView = findViewById(R.id.recycler_view);
//
//        task = getResources().getStringArray(R.array.list_task);
//        deadline = getResources().getStringArray(R.array.list_deadline);
//        note = getResources().getStringArray(R.array.list_catatan);
//        create = getResources().getStringArray(R.array.list_tglCreate);
//
//        MyAdapter myAdapter = new MyAdapter(this, task, deadline, create);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
}