package com.example.amdocsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.amdocsapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener,
    AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding

    /* lateinit var cancelBtn:Button
     lateinit var emailEt:EditText
     lateinit var spinnerLangs:Spinner*/

    //var TAG = "MainActivity"
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)   //inflation
        Log.i(TAG,"oncreate")

      /*  emailEt = findViewById(R.id.etEmail)
        spinnerLangs = findViewById(R.id.languagesSpinner)*/
    //dive into the activity_main xml file which you inffflated recently and find a view in
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onstart")
        binding.etEmail.setOnFocusChangeListener(this)
        binding.languagesSpinner.onItemSelectedListener = this
        binding.btnCancel.setOnClickListener{
            Log.i(TAG,"cancel btn clicked")
        }

        binding.radioGroup.setOnCheckedChangeListener(this)
       /* binding.emailEt.setOnFocusChangeListener(this);
        binding.spinnerLangs.onItemSelectedListener = this

        cancelBtn = findViewById(R.id.btnCancel)
        cancelBtn.setOnClickListener(View.OnClickListener {
            Log.i(TAG,"cancel btn clicked")

        })*/
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item = parent?.selectedItem.toString()
        Log.i(TAG,item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if (checkedId == R.id.maleRb){
            Log.i(TAG,"male selected")

        }
        else{
            Log.i(TAG,"female selected")

        }
    }


}