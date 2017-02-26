package com.example.firoz.smsreceiver;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);

        Bundle data2 = getIntent().getExtras();
        if (data2 != null) {
            String phonenumber = data2.getString("phone");
            String message = data2.getString("msg");
            t1.setText("From: "+phonenumber);
            t2.setText("Message: "+message);
        }
    }
}
