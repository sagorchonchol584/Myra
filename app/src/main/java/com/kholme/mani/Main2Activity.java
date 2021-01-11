package com.kholme.mani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView textVie,textVie1,textVie2,textVie3;
    EditText edPhone,editText;
    Button button;
    Main2Activity main2Activity;
    public static Main2Activity mThis = null;
    @Override
    protected void onResume() {
        super.onResume();
        mThis = this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        mThis = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edPhone = (EditText) findViewById(R.id.editTextPhoneNo);
        editText = (EditText) findViewById(R.id.meage);

        textVie=(TextView)findViewById(R.id.textView);
        textVie1=(TextView)findViewById(R.id.textView2);
        textVie2=(TextView)findViewById(R.id.textView3);
        textVie3=(TextView)findViewById(R.id.textView4);
		String smspin = textVie3.getText().toString();



        // textVie3=(TextView)findViewById(R.id.textView4);
        button=(Button)findViewById(R.id.buttont);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button();
            }
        });

    }

    protected void button() {
        String toPhoneNumber =edPhone.getText().toString();
        String smsMessage = textVie2.getText().toString();


//
//        String alll=smsMessage;
//        String[] parts = alll.split(",");
//
//        String a= parts[0];
//
//        String f= parts[5];
//
//
//        String partstwo=f;
//
//        String sub=partstwo.substring(4, 12);
//
        String smsMessagepin = editText.getText().toString();
        String smspin = textVie3.getText().toString();
        // String smsMessage=smsMessag+editText.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(toPhoneNumber, null, "YES "+smspin+" "+smsMessagepin, null, null);
            Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(intent);


            //  Toast.makeText(getApplicationContext(), "SMS sent success.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "বার্তা ব্যর্থ। আবার চেষ্টা করুন...", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}
