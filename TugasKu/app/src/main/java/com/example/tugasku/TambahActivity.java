package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.tugasku.EXTRA_TITLE";
    public static final String EXTRA_CREATE = "com.example.tugasku.EXTRA_CREATE";
    public static final String EXTRA_DEADLINE = "com.example.tugasku.EXTRA_DEADLINE";
    public static final String EXTRA_NOTE = "com.example.tugasku.EXTRA_NOTE";

    private EditText editTextTitle;
    private EditText editTextCreate;
    private EditText editTextDeadline;
    private EditText editTextNote;
    private Button btnNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editTextTitle = findViewById(R.id.editTextJudul);
        editTextCreate = findViewById(R.id.editTextCreate);
        editTextDeadline = findViewById(R.id.editTextDeadline);
        editTextNote = findViewById(R.id.editTextCatatan);

        btnNewTask = findViewById(R.id.button_add);
        btnNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String tglCreate = editTextCreate.getText().toString();
                String deadline = editTextDeadline.getText().toString();
                String catatan = editTextNote.getText().toString();
                Intent intent = new Intent();
                if(title.trim().isEmpty() || tglCreate.trim().isEmpty() || deadline.trim().isEmpty()) {
                    Toast.makeText(TambahActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TambahActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                    Task task = new Task(title, tglCreate, deadline, catatan);
                    TaskViewModel taskViewModel = new ViewModelProvider(TambahActivity.this).get(TaskViewModel.class);
                    taskViewModel.insert(task);
                }
                finish();
            }
        });
    }
}