package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class billProsse extends AppCompatActivity {

	Button buttonSendPross;
	EditText textPhoneNoPross;
	EditText textSMSPross;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bill_prosse);

		buttonSendPross = (Button) findViewById(R.id.buttonSendPross);
		textPhoneNoPross = (EditText) findViewById(R.id.editTextPhoneNoPross);
		textSMSPross = (EditText) findViewById(R.id.editTextSMSPross);



		buttonSendPross.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String phone = textPhoneNoPross.getText().toString();
				String sms = textSMSPross.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phone, null,"Regs "+sms, null, null);
					Toast.makeText(getApplicationContext(), "বার্তা পাঠান",
							Toast.LENGTH_LONG).show();

					Intent intent=new Intent(getApplicationContext(),Owner.class);
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




	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main2, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			// action with ID action_refresh was selected

			case R.id.item0:
				Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				break;



			default:
				break;
		}

		return true;
	}


	}

