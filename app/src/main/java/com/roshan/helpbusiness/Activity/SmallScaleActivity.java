package com.roshan.helpbusiness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.roshan.helpbusiness.R;

public class SmallScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_scale);


        Button goToCreateProductBtn = findViewById(R.id.goToCreateProductBtn);

        goToCreateProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SmallScaleActivity.this,CreateProductActivity.class));
            }
        });

    }
}