package com.roshan.helpbusiness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.roshan.helpbusiness.R;

public class BusinessTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_type);

        Button goToLargeScaleBtn = findViewById(R.id.largeScaleBtn);
        Button goToSmallScaleBtn = findViewById(R.id.smallScaleBtn);

        goToLargeScaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusinessTypeActivity.this,LargeScaleActivity.class));

            }
        });

        goToSmallScaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BusinessTypeActivity.this,SmallScaleActivity.class));
            }
        });
    }
}