package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailTaskActivity extends AppCompatActivity {

    private TextView title;
    private TextView deadline;
    private TextView note;

    private String mTitle;
    private String mDeadline;
    private String mNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        title = findViewById(R.id.text_ket_title);
        deadline = findViewById(R.id.text_ket_deadline);
        note = findViewById(R.id.text_ket_catatan);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("judulTugas") && getIntent().hasExtra("tgl_deadline") && getIntent().hasExtra("catatan_tugas")) {
            mTitle = getIntent().getStringExtra("judulTugas");
            mDeadline = getIntent().getStringExtra("tgl_deadline");
            mNote = getIntent().getStringExtra("catatan_tugas");
        } else {
            Toast.makeText(this, "Tidak ada data tugas", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(mTitle);
        deadline.setText(mDeadline);
        note.setText(mNote);
    }

    public void edit_task(View view) {
        Intent intent = new Intent(this, EditTaskActivity.class);
        startActivity(intent);
    }
}