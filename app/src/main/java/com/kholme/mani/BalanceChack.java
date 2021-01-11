package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BalanceChack extends AppCompatActivity {
Button button;
EditText editText,number;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_balance_chack);
        editText=(EditText)findViewById(R.id.editText);
		number=(EditText)findViewById(R.id.editText2);

			button=(Button) findViewById(R.id.button2);


		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String phone = number.getText().toString();
				String sms = editText.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phone, null, sms, null, null);
					Toast.makeText(getApplicationContext(), "বার্তা পাঠান",
							Toast.LENGTH_LONG).show();

					Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
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
