package com.example.retrofitproject.GET.delayed_response;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DelayedResponseActivity extends AppCompatActivity {

    RecyclerView rv_delayed;
    DelayedAdapter adapter;
    List<DataItem> list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_response);

        rv_delayed = findViewById(R.id.rv_delayed_response);

        RestClient.getService().getDelayedResponse().enqueue(new Callback<DelayedResponse>() {
            @Override
            public void onResponse(Call<DelayedResponse> call, Response<DelayedResponse> response) {
                if (response.isSuccessful()) {
                    list_item = response.body().getData();
                    adapter = new DelayedAdapter(DelayedResponseActivity.this, list_item);
                    rv_delayed.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv_delayed.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<DelayedResponse> call, Throwable t) {

            }
        });
    }
}