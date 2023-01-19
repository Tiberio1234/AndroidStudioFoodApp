package com.example.myfooapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.myfooapp.R;

public class WelcomeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome2);
    }

    public void Register(View view) {
        startActivity(new Intent(WelcomeActivity2.this, RegistrationActivity.class));
    }

    public void Login(View view) {
        startActivity(new Intent(WelcomeActivity2.this, LoginActivity2.class));
    }
}