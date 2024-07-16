package com.example.amdocsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var countries = arrayOf("India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia"
    ,"India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia",
        "India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia",
        "India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia",
        "India","usa","uk","australia","India","usa","uk","australia","India","usa","uk","australia")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        recyclerView = findViewById(R.id.recyclerView)

       var myadapter = CountriesAdapter(countries)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myadapter
    }
}