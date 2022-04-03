package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class TambahActivity extends AppCompatActivity {

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

        // calender class's instance and get current date , month and year from calender
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

        editTextCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(TambahActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // set day of month , month and year value in the edit text
                        editTextCreate.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        editTextDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(TambahActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // set day of month , month and year value in the edit text
                        editTextDeadline.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

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
                    Toast.makeText(TambahActivity.this, "Tugas gagal ditambahkan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TambahActivity.this, "Tugas berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    Task task = new Task(title, tglCreate, deadline, catatan);
                    TaskViewModel taskViewModel = new ViewModelProvider(TambahActivity.this).get(TaskViewModel.class);
                    taskViewModel.insert(task);
                }
                finish();
            }
        });
    }
}