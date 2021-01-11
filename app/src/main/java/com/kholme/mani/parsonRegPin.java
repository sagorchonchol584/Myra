package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class parsonRegPin extends AppCompatActivity {
	TextView textVie;
	EditText edPhone, edPhone1,editText;
	Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parson_reg_pin);


		button=(Button)findViewById(R.id.parson1);
		//pin number
		edPhone=(EditText) findViewById(R.id.parson);
       //text
		editText=(EditText) findViewById(R.id.parson2);
		//phone number
		edPhone1=(EditText) findViewById(R.id.parsona3);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				button();
			}
		});

	}

	protected void button() {
		String toPhoneNumber =edPhone1.getText().toString();
		String smsMessage = editText.getText().toString();
		String pin = edPhone.getText().toString();


		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(toPhoneNumber, null,smsMessage+""+pin, null, null);
			Intent intent=new Intent(getApplicationContext(),itemtwo.class);
			startActivity(intent);


			//  Toast.makeText(getApplicationContext(), "SMS sent success.", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "বার্তা ব্যর্থ। আবার চেষ্টা করুন...", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

}
