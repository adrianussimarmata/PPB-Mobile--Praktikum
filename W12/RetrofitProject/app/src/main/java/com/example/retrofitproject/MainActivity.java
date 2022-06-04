package com.example.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitproject.DELETE.DeleteActivity;
import com.example.retrofitproject.GET.delayed_response.DelayedResponseActivity;
import com.example.retrofitproject.GET.list_resource.ListResourceActivity;
import com.example.retrofitproject.GET.list_user.ListUserActivity;
import com.example.retrofitproject.GET.single_resource.SingleResourceActivity;
import com.example.retrofitproject.GET.single_resource_not_found.SingleResourceNotFoundActivity;
import com.example.retrofitproject.GET.single_user.SingleUserActivity;
import com.example.retrofitproject.GET.single_user_not_found.SingleUserNotFoundActivity;
import com.example.retrofitproject.PATCH.updatePatch.UpdatePatchActivity;
import com.example.retrofitproject.POST.create.CreateActivity;
import com.example.retrofitproject.POST.login_successful.LoginSuccessfulActivity;
import com.example.retrofitproject.POST.login_unsuccessful.LoginUnsuccessfulActivity;
import com.example.retrofitproject.POST.register_successful.RegisterSuccessfulActivity;
import com.example.retrofitproject.POST.register_unsuccessful.RegisterUnsuccessfulActivity;
import com.example.retrofitproject.PUT.update.UpdateActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getListUsers(View view) {
        intent = new Intent(MainActivity.this, ListUserActivity.class);
        startActivity(intent);
        finish();
    }

    public void getSingleUser(View view) {
        intent = new Intent(MainActivity.this, SingleUserActivity.class);
        startActivity(intent);
        finish();
    }

    public void getSingleUserNotFound(View view) {
        intent = new Intent(MainActivity.this, SingleUserNotFoundActivity.class);
        startActivity(intent);
        finish();
    }

    public void getListResource(View view) {
        intent = new Intent(MainActivity.this, ListResourceActivity.class);
        startActivity(intent);
        finish();
    }

    public void getSingleResource(View view) {
        intent = new Intent(MainActivity.this, SingleResourceActivity.class);
        startActivity(intent);
        finish();
    }

    public void getSingleResourceNotFound(View view) {
        intent = new Intent(MainActivity.this, SingleResourceNotFoundActivity.class);
        startActivity(intent);
        finish();
    }

    public void getDelayedResponse(View view) {
        intent = new Intent(MainActivity.this, DelayedResponseActivity.class);
        startActivity(intent);
        finish();
    }

    public void postCreate(View view) {
        intent = new Intent(MainActivity.this, CreateActivity.class);
        startActivity(intent);
        finish();
    }

    public void getRegisterSuccessful(View view) {
        intent = new Intent(MainActivity.this, RegisterSuccessfulActivity.class);
        startActivity(intent);
        finish();
    }

    public void getRegisterUnsuccessful(View view) {
        intent = new Intent(MainActivity.this, RegisterUnsuccessfulActivity.class);
        startActivity(intent);
        finish();
    }

    public void getLoginSuccessful(View view) {
        startActivity(new Intent(MainActivity.this, LoginSuccessfulActivity.class));
        finish();
    }

    public void getLoginUnsuccessful(View view) {
        startActivity(new Intent(MainActivity.this, LoginUnsuccessfulActivity.class));
        finish();
    }

    public void getUpdate(View view) {
        startActivity(new Intent(MainActivity.this, UpdateActivity.class));
        finish();
    }

    public void getUpdatePatch(View view) {
        startActivity(new Intent(MainActivity.this, UpdatePatchActivity.class));
        finish();
    }

    public void getDelete(View view) {
        startActivity(new Intent(MainActivity.this, DeleteActivity.class));
        finish();
    }
}