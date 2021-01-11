package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Owner extends AppCompatActivity {

	TextView textVieowner;
	EditText edPhoner;
	Button buttonowner;
    Owner owner;
	public static Owner ownersms = null;

	Spinner spinner;


	@Override
	protected void onResume() {
		super.onResume();
		ownersms = this;
	}
	@Override
	protected void onPause() {
		super.onPause();
		ownersms = null;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_owner);

		textVieowner=(TextView)findViewById(R.id.textViewowner);
		edPhoner=(EditText) findViewById(R.id.editTextPhoneNoowner);

		buttonowner=(Button) findViewById(R.id.buttontowner);
        spinner=(Spinner) findViewById(R.id.spinner);
        String [] monther={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		 ArrayAdapter <String> adapter= new ArrayAdapter<String>(Owner.this,android.R.layout.simple_spinner_dropdown_item,monther);
		 spinner.setAdapter(adapter);



		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
									   int position, long id) {

				Toast.makeText(Owner.this, spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});






		buttonowner.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String Manthe = spinner.getSelectedItem().toString();
				String phone = edPhoner.getText().toString();
				String sms = textVieowner.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phone, null,sms+" "+Manthe, null, null);
					Toast.makeText(getApplicationContext(), "বার্তা পাঠান",
							Toast.LENGTH_LONG).show();

					Intent intent=new Intent(getApplicationContext(),OwnerBilPay.class);
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
