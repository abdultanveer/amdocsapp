package com.example.amdocsapp

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
}