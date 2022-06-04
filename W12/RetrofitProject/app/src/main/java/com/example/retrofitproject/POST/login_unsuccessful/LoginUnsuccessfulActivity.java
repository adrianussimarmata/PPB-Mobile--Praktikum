package com.example.retrofitproject.POST.login_unsuccessful;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUnsuccessfulActivity extends AppCompatActivity {

    EditText email;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_unsuccessful);

        email = findViewById(R.id.email_login);
        btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyLoginUnsuccessful bodyLoginUnsuccessful = new BodyLoginUnsuccessful();
                bodyLoginUnsuccessful.setEmail(email.getText().toString());

                RestClient.getService().postLoginUnsuccessful(bodyLoginUnsuccessful).enqueue(new Callback<LoginUnsuccessfulResponse>() {
                    @Override
                    public void onResponse(Call<LoginUnsuccessfulResponse> call, Response<LoginUnsuccessfulResponse> response) {
                        Toast.makeText(LoginUnsuccessfulActivity.this, response.body().getError(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginUnsuccessfulResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}