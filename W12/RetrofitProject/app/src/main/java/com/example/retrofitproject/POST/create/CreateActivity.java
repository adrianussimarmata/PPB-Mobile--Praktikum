package com.example.retrofitproject.POST.create;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    EditText edit_name, edit_job;
    TextView res_code, id, name, job, time_create;
    String dName, dJob;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        edit_name = findViewById(R.id.form_name);
        edit_job = findViewById(R.id.form_job);
        res_code = findViewById(R.id.value_response_code);
        id = findViewById(R.id.value_id);
        name = findViewById(R.id.value_name);
        job = findViewById(R.id.value_job);
        time_create = findViewById(R.id.value_time);

        btn_send = findViewById(R.id.btn_submit);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dName = edit_name.getText().toString();
                dJob = edit_job.getText().toString();

                RestClient.getService().getUserInformation(dName, dJob).enqueue(new Callback<CreateResponse>() {
                    @Override
                    public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                        res_code.setText(String.valueOf(response.code()));
                        id.setText(response.body().getId());
                        name.setText(response.body().getName());
                        job.setText(response.body().getJob());
                        time_create.setText(response.body().getCreatedAt());
                    }

                    @Override
                    public void onFailure(Call<CreateResponse> call, Throwable t) {
                        Toast.makeText(CreateActivity.this, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}