package com.example.amdocsapp

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ContentProviderActivity : AppCompatActivity() {

    lateinit var cpListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_content_provider)
        cpListView = findViewById(R.id.listView)

        val uriSms = Uri.parse("content://sms/inbox")
        val cursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)

        var from = arrayOf("address","body")
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)

        var simpleCursorAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,cursor,from,to,0)

        cpListView.adapter = simpleCursorAdapter

    }
}