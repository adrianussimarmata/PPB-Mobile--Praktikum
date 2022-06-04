package com.example.retrofitproject.PATCH.updatePatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofitproject.PUT.update.UpdateBody;
import com.example.retrofitproject.PUT.update.UpdateResponse;
import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class UpdatePatchActivity extends AppCompatActivity {

    EditText name, job;
    Button btn_update;
    TextView res_code, res_name, res_job, res_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_patch);

        name = findViewById(R.id.form_name);
        job = findViewById(R.id.form_job);
        res_code = findViewById(R.id.value_response_code);
        res_name = findViewById(R.id.value_name);
        res_job = findViewById(R.id.value_job);
        res_time = findViewById(R.id.value_time);

        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyUpdatePatch updateBody = new BodyUpdatePatch();
                updateBody.setName(name.getText().toString());
                updateBody.setJob(job.getText().toString());

                RestClient.getService().patchUpdate(updateBody).enqueue(new Callback<UpdatePatchResponse>() {
                    @Override
                    public void onResponse(Call<UpdatePatchResponse> call, Response<UpdatePatchResponse> response) {
                        res_code.setText(String.valueOf(response.code()));
                        res_name.setText(response.body().getName());
                        res_job.setText(response.body().getJob());
                        res_time.setText(response.body().getUpdatedAt());
                    }

                    @Override
                    public void onFailure(Call<UpdatePatchResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}