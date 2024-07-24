package com.example.amdocsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amdocsapp.di.DaggerMyComponent;
import com.example.amdocsapp.di.MyComponent;
import com.example.amdocsapp.di.SharedPrefModule;

import javax.inject.Inject;

public class DiActivity extends AppCompatActivity {
    private MyComponent myComponent;
    EditText etName;
    EditText etPhno;
    @Inject
    SharedPreferences sharedPreferences;
    //this instance will be created in the factory and provided on demmand
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);
        etName = findViewById(R.id.inUsername);
        etPhno = findViewById(R.id.inNumber);
        myComponent = DaggerMyComponent.builder()
                .sharedPrefModule(new SharedPrefModule(this))
                .build();
        myComponent.inject(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {

        String name = etName.getText().toString();
        String phno = etPhno.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("namek",name);
        editor.putString("phk",phno);
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void restoreData() {
        etName.setText(sharedPreferences.getString("namek",""));
        etPhno.setText(sharedPreferences.getString("phk",""));
    }
}