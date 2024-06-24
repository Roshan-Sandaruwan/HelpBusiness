package com.roshan.helpbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        ---splash screen login and Register buttons---

        Button spLoginBtn = findViewById(R.id.spLoginBtn);
        spLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        });

        Button spRegisterBtn = findViewById(R.id.spRegisterBtn);
        spRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,RegisterActivity.class));
            }
        });






    }
}