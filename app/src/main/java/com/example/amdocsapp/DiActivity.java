package com.example.amdocsapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class DiActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;
    //this instance will be created in the factory and provided on demmand
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);
    }
}