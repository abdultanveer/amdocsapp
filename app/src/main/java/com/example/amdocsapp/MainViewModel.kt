package com.example.amdocsapp

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    lateinit var timer: CountDownTimer
    var _seconds:Int =  0    //_ means its a mutable variable

    var dataDbWebservice = 0

    fun incrementCounter(){
        dataDbWebservice++
    }

    fun startTimer() {
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(millisUntilFinished: Long) {
                _seconds = millisUntilFinished.toInt()
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