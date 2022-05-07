package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
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

        Calendar c = Calendar.getInstance();
        editTextCreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDateTimeDialog(editTextCreate);
            }
        });

        editTextDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(editTextDeadline);
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

    private void showDateTimeDialog(EditText date_time_in) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(TambahActivity.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
            }
        };
        new DatePickerDialog(TambahActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}