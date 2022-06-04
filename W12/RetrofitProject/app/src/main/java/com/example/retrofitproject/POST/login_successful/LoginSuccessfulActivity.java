package com.example.retrofitproject.POST.login_successful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitproject.MainActivity;
import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginSuccessfulActivity extends AppCompatActivity {

    EditText email, password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);

        email = findViewById(R.id.tvUsername);
        password = findViewById(R.id.edtPassword);

        btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyLogin bodyLogin = new BodyLogin();
                bodyLogin.setEmail(email.getText().toString());
                bodyLogin.setPassword(password.getText().toString());

                RestClient.getService().postLoginSuccessful(bodyLogin).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(LoginSuccessfulActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginSuccessfulActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}