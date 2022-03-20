package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TugasViewModel tugasViewModel;
    private Button btnTambahTugas;
    public static final int ADD_TASK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambahTugas = findViewById(R.id.button_tambah);
        btnTambahTugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                startActivityForResult(intent, ADD_TASK_REQUEST);
            }
        });
    }

//    public void tambah_tugas(View view) {
//        Intent intent = new Intent(MainActivity.this, TambahActivity.class);
//        startActivity(intent);
//    }

    public void lihat_tugas(View view) {
        Intent intent = new Intent(MainActivity.this, LihatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_TASK_REQUEST) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra(TambahActivity.EXTRA_TITLE);
                String tglCreate = data.getStringExtra(TambahActivity.EXTRA_CREATE);
                String deadline = data.getStringExtra(TambahActivity.EXTRA_DEADLINE);
                String note = data.getStringExtra(TambahActivity.EXTRA_NOTE);

                Tugas tugas = new Tugas(title, tglCreate, deadline, note);
                tugasViewModel.insertTugas(tugas);

                Toast.makeText(this, "Tugas berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Tugas gagal ditambahkan", Toast.LENGTH_SHORT).show();
        }
    }

//    public void TambahTugas(Context context) {
//        View view1 = getLayoutInflater().inflate(R.layout.activity_tambah, null);
//
//        Button tambahTugas = view1.findViewById(R.id.button_add);
//        tambahTugas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText editJudulTugas = view1.findViewById(R.id.text_task);
//                EditText editTglMasuk = view1.findViewById(R.id.text_tglCreate);
//                EditText editTglDeadline = view1.findViewById(R.id.text_deadline);
//                EditText editCatatanTugas = view1.findViewById(R.id.text_note);
//
//                Tugas tugas = new Tugas();
//                tugas.setJudul_tugas(editJudulTugas.getText().toString());
//                tugas.setTgl_tugas_masuk(editTglMasuk.getText().toString());
//                tugas.setTgl_deadline(editTglDeadline.getText().toString());
//                tugas.setCatatan(editCatatanTugas.getText().toString());
//
//                tugasViewModel.insertTugas(tugas);
//            }
//        });
//    }
}