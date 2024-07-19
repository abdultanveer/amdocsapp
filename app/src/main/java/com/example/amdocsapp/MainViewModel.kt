package com.example.amdocsapp

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var dataDbWebservice = 0

    fun incrementCounter(){
        dataDbWebservice++
    }

}