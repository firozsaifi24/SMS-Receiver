package com.example.firoz.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;
import android.app.Activity;


public class MyReceiver extends BroadcastReceiver {

    String msg;
    String number;
    public MyReceiver() {
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            SmsManager smsManager=SmsManager.getDefault();
            Bundle bundle=intent.getExtras();



            if(bundle!=null)
            {
                Object[] pdus=(Object[])bundle.get("pdus");

                for (int i = 0; i < pdus.length; i++) {


                    SmsMessage messages = SmsMessage.createFromPdu((byte[]) pdus[i]);

                    msg=messages.getMessageBody();
                    number=messages.getOriginatingAddress();
                    Toast.makeText(context, "Phone: " + number + "\n" + "Message: " + msg, Toast.LENGTH_LONG).show();

                }
                if(msg!=null)
                {
                    Intent data=new Intent(context,MainActivity.class);
                    data.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    data.putExtra("phone",number);
                    data.putExtra("msg",msg);
                    context.startActivity(data);
                }

            }


        }
    }
}
