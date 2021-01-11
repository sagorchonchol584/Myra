package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Billchaking extends AppCompatActivity {
    TextView textVie,textVie1,textVie2,textVie3;
    EditText edPhone,editText;
    Button button;
    Billchaking billchaking;
    public static Billchaking bilmThis = null;
    @Override
    protected void onResume() {
        super.onResume();
        bilmThis = this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        bilmThis = null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billchaking);



        button=(Button)findViewById(R.id.button);
        textVie=(TextView)findViewById(R.id.textViewtwo);





        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button();
            }
        });

    }

    protected void button() {

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);


        //  Toast.makeText(getApplicationContext(), "SMS sent success.", Toast.LENGTH_LONG)
    }


}


