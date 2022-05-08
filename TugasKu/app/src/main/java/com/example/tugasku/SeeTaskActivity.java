package com.example.tugasku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class SeeTaskActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskViewModel taskViewModel;
    private TaskAdapter taskAdapter;
//    private String task[], tglCreate[], deadline[], note[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_task);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        taskAdapter = new TaskAdapter(this);
        recyclerView.setAdapter(taskAdapter);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
//                Toast.makeText(SeeTaskActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
                taskAdapter.setTasks(tasks);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                taskViewModel.delete(taskAdapter.getTaskAt(viewHolder.getAdapterPosition()));
                Toast.makeText(SeeTaskActivity.this, "Tugas telah dihapus", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

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