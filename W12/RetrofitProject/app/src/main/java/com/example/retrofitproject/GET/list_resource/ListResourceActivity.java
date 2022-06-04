package com.example.retrofitproject.GET.list_resource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListResourceActivity extends AppCompatActivity {

    RecyclerView recycler_list_resource;
    ListResourceAdapter adapter;
    List<DataItem> list_resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resource);

        recycler_list_resource = findViewById(R.id.rv_list_resource);

        RestClient.getService().getListResource().enqueue(new Callback<ListResourceResponse>() {
            @Override
            public void onResponse(Call<ListResourceResponse> call, Response<ListResourceResponse> response) {
                if (response.isSuccessful()) {
                    list_resource = response.body().getData();
                    adapter = new ListResourceAdapter(ListResourceActivity.this, list_resource);
                    recycler_list_resource.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recycler_list_resource.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListResourceResponse> call, Throwable t) {

            }
        });
    }
}