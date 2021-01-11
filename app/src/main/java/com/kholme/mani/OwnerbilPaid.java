package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OwnerbilPaid extends AppCompatActivity {

	TextView textVie;
	EditText edPhone,editText;
	Button button;
	OwnerbilPaid ownerbilPaid;
	public static OwnerbilPaid ownerpaid = null;

	@Override
	protected void onResume() {
		super.onResume();
		ownerpaid = this;
	}
	@Override
	protected void onPause() {
		super.onPause();
		ownerpaid = null;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ownerbil_paid);



		button=(Button)findViewById(R.id.button);
		textVie=(TextView)findViewById(R.id.textViewtwo);





		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				button();
			}
		});

	}

	protected void button() {




		Intent intent=new Intent(getApplicationContext(),billProsse.class);
		startActivity(intent);


		//  Toast.makeText(getApplicationContext(), "SMS sent success.", Toast.LENGTH_LONG)
	}


}

