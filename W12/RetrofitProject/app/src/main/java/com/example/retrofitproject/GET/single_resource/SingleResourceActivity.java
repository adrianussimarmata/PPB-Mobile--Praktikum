package com.example.retrofitproject.GET.single_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleResourceActivity extends AppCompatActivity {

    TextView mName, mYear, mColor, mPantoneValue;
    Data dataResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_resource);

        mName = findViewById(R.id.name);
        mYear = findViewById(R.id.year);
        mColor = findViewById(R.id.color);
        mPantoneValue = findViewById(R.id.pantone_value);

        RestClient.getService().getSingleResource().enqueue(new Callback<SingleResourceResponse>() {
            @Override
            public void onResponse(Call<SingleResourceResponse> call, Response<SingleResourceResponse> response) {
                if (response.isSuccessful()) {
                    dataResource = response.body().getData();
                    mName.setText(dataResource.getName());
                    mYear.setText(String.valueOf(dataResource.getYear()));
                    mColor.setText(dataResource.getColor());
                    mPantoneValue.setText(dataResource.getPantoneValue());
                }
            }

            @Override
            public void onFailure(Call<SingleResourceResponse> call, Throwable t) {

            }
        });
    }
}