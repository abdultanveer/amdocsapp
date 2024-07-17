package com.example.amdocsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
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

            binding.btnR.setOnClickListener{
                var rIntent = Intent(this,RecyclerActivity::class.java)
                var data = binding.etEmail.text.toString()
                rIntent.putExtra("ekey",data)
                //startActivity(rIntent)
                startActivityForResult(rIntent,123)
               // sendBroadcast(rIntent)
            }

        binding.btnDial.setOnClickListener{
            var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:8976543"))
            startActivity(dIntent)
        }
        binding.btnAlarm.setOnClickListener{
            createAlarm("amdocs",10,32)
        }
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

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
      //  if (intent.resolveActivity(packageManager) != null) {
        // checking if there's anny app which can serve my intent to set alarm
            startActivity(intent)
       // }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 123){
            var receivedData = data?.extras?.getString("conPh")
            binding.tvResult.text = receivedData
        }
    }


}