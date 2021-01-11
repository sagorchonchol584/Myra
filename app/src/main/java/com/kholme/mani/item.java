package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.kholme.mani.R.id.sendnumber;

public class item extends AppCompatActivity {
    Button LogInButton, RegisterButton ;
    EditText name, mobile,bil,sendnumbdr,reg ;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        sendnumbdr = (EditText)findViewById(sendnumber);
        LogInButton = (Button)findViewById(R.id.buttonreg);

               reg = (EditText)findViewById(R.id.reg);
               bil = (EditText)findViewById(R.id.bll);
            mobile = (EditText)findViewById(R.id.mobileNumber);
              name = (EditText)findViewById(R.id.names);




        LogInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
          while (i<=1 ) {
                String sendnumber =sendnumbdr.getText().toString();



                String regss = reg.getText().toString();
                  String sms = bil.getText().toString();
              String phone = mobile.getText().toString();
                  String nam = name.getText().toString();



                try {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(sendnumber, null, regss+" "+sms+" "+phone+" "+nam, null, null);
                    Toast.makeText(getApplicationContext(), "পাঠানো হলো..",
                            Toast.LENGTH_LONG).show();
                    i++;
                    Intent intent=new Intent(getApplicationContext(),parsonRegPin.class);
                    startActivity(intent);


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "বার্তা ব্যর্থ। আবার চেষ্টা করুন...",
                            Toast.LENGTH_LONG).show();



                    e.printStackTrace();
                }

            }

            } });


    }



}
