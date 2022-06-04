package com.example.retrofitproject.GET.single_resource_not_found;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleResourceNotFoundActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_resource_not_found);

        result = findViewById(R.id.text_response);

        RestClient.getService().getSingleResourceNotFound().enqueue(new Callback<SingleResourceNotFoundResponse>() {
            @Override
            public void onResponse(Call<SingleResourceNotFoundResponse> call, Response<SingleResourceNotFoundResponse> response) {
                if (!response.isSuccessful()) {
                    result.setText("Resource Not Found\n" + "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<SingleResourceNotFoundResponse> call, Throwable t) {

            }
        });
    }
}