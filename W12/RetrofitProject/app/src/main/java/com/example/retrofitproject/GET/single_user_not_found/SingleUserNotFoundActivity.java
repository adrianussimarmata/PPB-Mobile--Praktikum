package com.example.retrofitproject.GET.single_user_not_found;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserNotFoundActivity extends AppCompatActivity {

    TextView text_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_not_found);

        text_response = findViewById(R.id.text_response);

        RestClient.getService().getSingleUserNotFound().enqueue(new Callback<SingleUserNotFoundResponse>() {
            @Override
            public void onResponse(Call<SingleUserNotFoundResponse> call, Response<SingleUserNotFoundResponse> response) {
                if (response.isSuccessful()) {
                    text_response.setText("Successful");
                }
                else {
                    text_response.setText("User Not Found\n" + "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<SingleUserNotFoundResponse> call, Throwable t) {

            }
        });
    }
}