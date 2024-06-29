package com.roshan.helpbusiness.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Helpbusiness.db";

    public DBHelper(Context context) {
        super(context, "Helpbusiness.db", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        ---CREATE USER TABLE--

        db.execSQL("CREATE TABLE users(username TEXT  PRIMARY KEY , email TEXT, password TEXT)");

//        ---CREATE PRODUCT TABLE---

        db.execSQL("CREATE TABLE products(id INTEGER PRIMARY KEY AUTOINCREMENT, shortTitle TEXT, productTitle TEXT, productDescription TEXT, productOwnerPhone TEXT, productOwnerEmail TEXT, productOwnerLocation TEXT, oneProductPrice TEXT, allProductPrice TEXT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

//        ---USER TABLE---

        db.execSQL("DROP TABLE IF EXISTS users");

//        ---PRODUCT TABLE---

        db.execSQL("DROP TABLE IF EXISTS products");


        onCreate(db); //--error after add

    }

//    ---USER TABLE---

    public Boolean insertData(String username, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);

        long result = db.insert("users", null,contentValues); //-- add table to data

        if (result==-1)
            return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?" , new String[] {username});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[]{username,password});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


//    ---PRODUCT TABLE---

    public Boolean insertProductData(String shortTitle,
                                     String productTitle,
                                     String productDescription,
                                     String productOwnerPhone,
                                     String productOwnerEmail,
                                     String productOwnerLocation,
                                     String oneProductPrice,
                                     String allProductPrice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("shortTitle",shortTitle);
        contentValues.put("productTitle",productTitle);
        contentValues.put("productDescription",productDescription);
        contentValues.put("productOwnerPhone",productOwnerPhone);
        contentValues.put("productOwnerEmail",productOwnerEmail);
        contentValues.put("productOwnerLocation",productOwnerLocation);
        contentValues.put("oneProductPrice",oneProductPrice);
        contentValues.put("allProductPrice",allProductPrice);

        long result = db.insert("products", null,contentValues);

        if (result==-1)
            return false;
        else
            return true;
    }

    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from products", null);
        return cursor;
    }









}
