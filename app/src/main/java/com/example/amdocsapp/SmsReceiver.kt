package com.example.amdocsapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {
var TAG = SmsReceiver::class.java.simpleName
    override fun onReceive(context: Context, intent: Intent) {

        val message = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        val content =  message[0].displayMessageBody
       Log.i(TAG,"abdul u 've an sms--"+content+"phno --"+message[0].originatingAddress)
    }
}