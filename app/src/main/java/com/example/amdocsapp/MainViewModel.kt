package com.example.amdocsapp

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    lateinit var timer: CountDownTimer
    var _seconds =  MutableLiveData<Int>()
    //mutable = it can be changed, live == observed

    var dataDbWebservice = 0

    fun incrementCounter(){
        dataDbWebservice++
    }

    fun startTimer() {
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(millisUntilFinished: Long) {
                _seconds.value = millisUntilFinished.toInt()
                Log.i(TAG,"time remaining ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer has finished")
            }

        }.start();
    }

    companion object{
        var TAG = MainViewModel::class.java.simpleName
    }

    }