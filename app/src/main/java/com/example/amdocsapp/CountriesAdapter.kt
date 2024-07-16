package com.example.amdocsapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CountriesAdapter( var countries: Array<String>) : RecyclerView.Adapter<ReserveViewHolder>() {

    var TAG = CountriesAdapter::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReserveViewHolder {
        Log.i(TAG,"rishikesh bought a row plank from the market")
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return  ReserveViewHolder(rowPlank)
    }

    override fun onBindViewHolder(holder: ReserveViewHolder, position: Int) {
        Log.i(TAG,"sumit is writing-"+countries[position])
        holder.rowTextView.setText(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}

class ReserveViewHolder(rowPlank: View):ViewHolder(rowPlank) {
    var rowTextView:TextView = rowPlank.findViewById(R.id.tvRow)

init {
    Log.i("CountriesAdapter","vikash got the plank from rishikesh")
}
}
