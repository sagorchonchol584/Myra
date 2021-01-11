package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class billchack extends AppCompatActivity {

    Button buttonSend;
    EditText textPhoneNo;
    EditText textSMS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billchack);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
        textSMS = (EditText) findViewById(R.id.editTextSMS);

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phone = textPhoneNo.getText().toString();
                String sms = textSMS.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "পাঠানো হলো..",
                            Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),Billchaking.class);
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "বার্তা ব্যর্থ। আবার চেষ্টা করুন...",
                            Toast.LENGTH_LONG).show();



                    e.printStackTrace();
                }

            }
        });

    }
    }
