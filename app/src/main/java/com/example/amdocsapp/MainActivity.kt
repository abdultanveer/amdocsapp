package com.example.amdocsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener {
    lateinit var cancelBtn:Button
    lateinit var emailEt:EditText

    //var TAG = "MainActivity"
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)   //inflation
        Log.i(TAG,"oncreate")

        emailEt = findViewById(R.id.etEmail)
    //dive into the activity_main xml file which you inffflated recently and find a view in
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onstart")
        emailEt.setOnFocusChangeListener(this);

        cancelBtn = findViewById(R.id.btnCancel)
        cancelBtn.setOnClickListener(View.OnClickListener {
            Log.i(TAG,"cancel btn clicked")

        })
    }


    fun clickHandler(view: View) {
        //View myView = new View()
        var myView:View = findViewById(R.id.main)
        Snackbar.make(myView,"archived email",Snackbar.LENGTH_LONG)
            .setAction("undo", View.OnClickListener {  })
            .show()
    }

    override fun onFocusChange(emailEdittext: View?, hasFocus: Boolean) {
        if (hasFocus){
            Log.i(TAG,"has focus")
        }
        else {
            Log.i(TAG,"lost focus")

        }
    }


}