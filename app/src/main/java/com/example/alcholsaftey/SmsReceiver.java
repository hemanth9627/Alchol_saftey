package com.example.alcholsaftey;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        Object[] smsObj=(Object[]) bundle.get("pdus");
        for (Object obj:smsObj)
        {
            String format = bundle.getString("format");
            SmsMessage message =SmsMessage.createFromPdu((byte[]) obj,format);
            String mobno=message.getDisplayOriginatingAddress();
            String msg=message.getDisplayMessageBody();
            Log.d("MsgDetails","MobNo"+mobno+", Msg "+msg);
            if(msg.contains("Alert"))
            {
                sender.sendSMS("I have drunk alcohol please help me.");
            }
            else if(msg.contains("Danger"))
            {
                sender.sendSMS(" I faced an accident please help me.");
            }

        }

    }

}
