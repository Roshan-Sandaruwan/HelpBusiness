package com.roshan.helpbusiness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.roshan.helpbusiness.R;

public class CreateProductActivity extends AppCompatActivity {

    EditText shortTitle, productTitle,productDescription,productOwnerPhone,productOwnerEmail,productOwnerLocation,oneProductPrice,allProductPrice;
    Button insert,view;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

//        --- product create ---

        shortTitle = (EditText) findViewById(R.id.shortTitle);
        productTitle = (EditText) findViewById(R.id.productTitle);
        productDescription =(EditText) findViewById(R.id.productDescription);
        productOwnerPhone =(EditText) findViewById(R.id.productOwnerPhone);
        productOwnerEmail =(EditText) findViewById(R.id.productOwnerEmail);
        productOwnerLocation =(EditText) findViewById(R.id.productOwnerLocation);
        oneProductPrice =(EditText) findViewById(R.id.oneProductPrice);
        allProductPrice =(EditText) findViewById(R.id.allProductPrice);

        insert = findViewById(R.id.insertBtn);
        view = findViewById(R.id.viewBtn);

        DB = new DBHelper(this);


//        --- VIEW BUTTON ---
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateProductActivity.this,LargeScaleActivity.class));
            }
        });

//        ---PRODUCT DETAILS INSERT TO THE DB

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String shortTitleTxt = shortTitle.getText().toString();
                String productTitleTxt = productTitle.getText().toString();
                String productDescriptionTxt = productDescription.getText().toString();
                String productOwnerPhoneTxt = productOwnerPhone.getText().toString();
                String productOwnerEmailTxt = productOwnerEmail.getText().toString();
                String productOwnerLocationTxt = productOwnerLocation.getText().toString();
                String oneProductPriceTxt = oneProductPrice.getText().toString();
                String allProductPriceTxt = allProductPrice.getText().toString();

                Boolean checkinsertdata = DB.insertProductData(
                        shortTitleTxt,
                        productTitleTxt,
                        productDescriptionTxt,
                        productOwnerPhoneTxt,
                        productOwnerEmailTxt,
                        productOwnerLocationTxt,
                        oneProductPriceTxt,
                        allProductPriceTxt
                        );

                if(checkinsertdata==true){
                    Toast.makeText(CreateProductActivity.this, "New Product Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(CreateProductActivity.this, "Product is not added", Toast.LENGTH_SHORT).show();
                }
            }
        });



//        --- BACK BUTTON ---

        ImageView productCreateBackBtn = findViewById(R.id.productCreateBackBtn);
        productCreateBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateProductActivity.this,SmallScaleActivity.class));
            }
        });

    }
}