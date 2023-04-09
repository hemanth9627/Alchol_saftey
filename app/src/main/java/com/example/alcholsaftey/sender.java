package com.example.alcholsaftey;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.*;

public class sender {
    public static ArrayList<n1> ar=new ArrayList<>();
    public static void sendSMS(String msg){

        for(n1 h: ar)
        {
            SmsManager mySmsManager = SmsManager.getDefault();
            mySmsManager.sendTextMessage(h.mbn,null, h.name+" "+msg+"\nLocation: https://goo.gl/maps/13w242VQgBtTWtxRA", null, null);
        }

    }
    public static void add(String n,String r,String m)
    {
        n1 k=new n1(n,r,m);
        ar.add(k);
    }
    public static void rem(String n,String m)
    {
        for(n1 k:ar)
        {
            if(k.mbn==m && k.name==n)
            {
                ar.remove(k);
                break;
            }
        }
    }
    public void edit(String n,String r,String m,String on,String or,String om)
    {
        for(n1 k:ar)
        {
            if(k.mbn==m && k.name==n && k.rel==r)
            {
                ar.remove(k);
                break;
            }
        }
        n1 k=new n1(on,or,om);
        ar.add(k);
    }
}
