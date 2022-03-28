package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class LihatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskViewModel taskViewModel;
    private TaskAdapter taskAdapter;
//    private String task[], tglCreate[], deadline[], note[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        taskAdapter = new TaskAdapter();
        recyclerView.setAdapter(taskAdapter);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
//                Toast.makeText(LihatActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
                taskAdapter.setTasks(tasks);
            }
        });

//        recyclerView = findViewById(R.id.recycler_view);
//        task = getResources().getStringArray(R.array.list_task);
//        tglCreate = getResources().getStringArray(R.array.list_tglCreate);
//        deadline = getResources().getStringArray(R.array.list_deadline);
//        note = getResources().getStringArray(R.array.list_catatan);
//
//        myAdapter = new MyAdapter(this, task, tglCreate, deadline, note);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}