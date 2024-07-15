package com.example.amdocsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    //var TAG = "MainActivity"
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i(TAG,"oncreate")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onstart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onpause")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"onresume")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onstop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"ondestroy")

    }

    fun clickHandler(view: View) {
        //View myView = new View()
        var myView:View = findViewById(R.id.main)
        Snackbar.make(myView,"archived email",Snackbar.LENGTH_LONG)
            .setAction("undo", View.OnClickListener {  })
            .show()
    }


}