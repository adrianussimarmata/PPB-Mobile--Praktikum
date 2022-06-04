package com.example.retrofitproject.POST.register_unsuccessful;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitproject.POST.register_successful.RegisterResponse;
import com.example.retrofitproject.R;
import com.example.retrofitproject.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUnsuccessfulActivity extends AppCompatActivity {

    EditText email;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unsuccessful);

        email = findViewById(R.id.form_email);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyRegisterUnsuccessful register_fail = new BodyRegisterUnsuccessful();
                register_fail.setEmail(email.getText().toString());

                RestClient.getService().postRegisterUnsuccessful(register_fail).enqueue(new Callback<RegisterUnsuccessfulResponse>() {
                    @Override
                    public void onResponse(Call<RegisterUnsuccessfulResponse> call, Response<RegisterUnsuccessfulResponse> response) {
                        Toast.makeText(RegisterUnsuccessfulActivity.this, response.body().getError(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegisterUnsuccessfulResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}