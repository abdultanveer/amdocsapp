package com.example.amdocsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amdocsapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    lateinit var  binding: ActivityRecyclerBinding

    var countries = arrayOf("India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia"
    ,"India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia",
        "India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia",
        "India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia",
        "India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        

       var myadapter = CountriesAdapter(countries)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myadapter
    }


    override fun onStart() {
        super.onStart()
        var dataReceived = intent.extras?.getString("ekey")
        binding.tvData?.text = dataReceived

        binding.btnSelect?.setOnClickListener{
            var contactPhoto = binding.etContact?.text.toString();
            var resIntent = Intent()
            resIntent.putExtra("conPh",contactPhoto)
            setResult(RESULT_OK,resIntent)
            finish()
        }
    }
}