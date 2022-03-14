package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tambah_tugas(View view) {
        Intent intent = new Intent(MainActivity.this, TambahActivity.class);
        startActivity(intent);
    }

    public void lihat_tugas(View view) {
        Intent intent = new Intent(MainActivity.this, LihatActivity.class);
        startActivity(intent);
    }
}