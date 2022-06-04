package com.example.retrofitproject.GET.single_user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserActivity extends AppCompatActivity {

    TextView first_name;
    TextView last_name;
    TextView email;
    ImageView avatar;
    Data dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

        first_name = findViewById(R.id.text_first_name);
        last_name = findViewById(R.id.text_last_name);
        email = findViewById(R.id.text_email);
        avatar = findViewById(R.id.img_avatar);

        RestClient.getService().getSingleUser().enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if (response.isSuccessful()) {
                    dataUser = response.body().getData();
                    first_name.setText(dataUser.getFirstName());
                    last_name.setText(dataUser.getLastName());
                    email.setText(dataUser.getEmail());
                    Glide.with(avatar).load(dataUser.getAvatar()).into(avatar);
                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {

            }
        });
    }
}