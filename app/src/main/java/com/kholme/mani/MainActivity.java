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

public class MainActivity extends AppCompatActivity {
    Button buttonSend;
    EditText textPhoneNo;
    EditText textSMS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    Toast.makeText(getApplicationContext(), "বার্তা পাঠান",
                            Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
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


    // this is manu bar 49-76
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected

			case R.id.item0:
				Intent intent=new Intent(getApplicationContext(),billProsse.class);
				startActivity(intent);
				break;


            case R.id.item1:
                 intent=new Intent(getApplicationContext(),item.class);
                startActivity(intent);
                break;


            // action with ID action_settings was selected
            case R.id.item2:
               // finish();

                intent=new Intent(getApplicationContext(),Home.class);
                startActivity(intent);

                Toast.makeText(this,"লগআউট সম্পূর্ন হয়েছে..", Toast.LENGTH_LONG).show();
                break;

            case R.id.item3:
                intent = new Intent(getApplicationContext(), billchack.class);
                startActivity(intent);
                break;
			case R.id.item4:
				intent = new Intent(getApplicationContext(), BalanceChack.class);
				startActivity(intent);
				break;

            default:
                break;
        }

        return true;
    }




}
