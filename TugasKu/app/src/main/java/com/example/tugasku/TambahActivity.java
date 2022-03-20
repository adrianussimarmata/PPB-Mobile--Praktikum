package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.tugasku.EXTRA_TITLE";
    public static final String EXTRA_CREATE = "com.example.tugasku.EXTRA_CREATE";
    public static final String EXTRA_DEADLINE = "com.example.tugasku.EXTRA_DEADLINE";
    public static final String EXTRA_NOTE = "com.example.tugasku.EXTRA_NOTE";
    private TugasViewModel tugasViewModel;
    private EditText editJudulTugas;
    private EditText editTglMasuk;
    private EditText editTglDeadline;
    private EditText editCatatanTugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        Button button = findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanTugas();
            }
        });

//        button.setOnClickListener(view -> {
//            Intent intent = new Intent();
//            if(TextUtils.isEmpty(editJudulTugas.getText()) || TextUtils.isEmpty(editTglMasuk.getText()) || TextUtils.isEmpty(editTglDeadline.getText()) || TextUtils.isEmpty(editCatatanTugas.getText())) {
//                setResult(RESULT_CANCELED, intent);
//            } else {
//                String title = editJudulTugas.getText().toString();
//                String tglCreate = editTglMasuk.getText().toString();
//                String deadline = editTglDeadline.getText().toString();
//                String catatan = editCatatanTugas.getText().toString();
//
//                intent.putExtra(EXTRA_TITLE, title);
//                intent.putExtra(EXTRA_CREATE, tglCreate);
//                intent.putExtra(EXTRA_DEADLINE, deadline);
//                intent.putExtra(EXTRA_NOTE, catatan);
//                setResult(RESULT_OK, intent);
//            }
//            finish();
//        });
    }

    private void simpanTugas() {
        String title = editJudulTugas.getText().toString();
        String tglCreate = editTglMasuk.getText().toString();
        String deadline = editTglDeadline.getText().toString();
        String catatan = editCatatanTugas.getText().toString();

        Intent intent = new Intent();
        if(title.trim().isEmpty() || tglCreate.trim().isEmpty() || deadline.trim().isEmpty() || catatan.trim().isEmpty()) {
            setResult(RESULT_CANCELED, intent);
        } else {
            intent.putExtra(EXTRA_TITLE, title);
            intent.putExtra(EXTRA_CREATE, tglCreate);
            intent.putExtra(EXTRA_DEADLINE, deadline);
            intent.putExtra(EXTRA_NOTE, catatan);
            setResult(RESULT_OK, intent);
        }
        finish();
    }

//        btnTambahTugas = findViewById(R.id.button_tambah);
//        btnTambahTugas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TambahTugas(TambahActivity.this);
//            }
//        });

//    public void TambahTugas(Context context) {
//        View view1 = getLayoutInflater().inflate(R.layout.activity_tambah, null);
//
//        Button tambahTugas = view1.findViewById(R.id.button_add);
//        tambahTugas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText editJudulTugas = view1.findViewById(R.id.editTextJudul);
//                EditText editTglMasuk = view1.findViewById(R.id.editTextCreate);
//                EditText editTglDeadline = view1.findViewById(R.id.editTextDeadline);
//                EditText editCatatanTugas = view1.findViewById(R.id.editTextCatatan);
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