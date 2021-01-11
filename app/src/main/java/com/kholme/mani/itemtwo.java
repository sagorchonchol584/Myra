package com.kholme.mani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class itemtwo extends AppCompatActivity {
    TextView textVie,textVie1,textVie2,textVie3;
    EditText edPhone,editText;
    Button button;
    itemtwo twto;
    public static itemtwo two = null;
    @Override
    protected void onResume() {
        super.onResume();
        two = this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        two = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemtwo);


        edPhone = (EditText) findViewById(R.id.editTextPhoneNo);

        textVie3=(TextView)findViewById(R.id.textView4);
		String buttonTip = textVie3.getText().toString();
      //  textVie2=(TextView)findViewById(R.id.textView6);

        // textVie3=(TextView)findViewById(R.id.textView4);
        button=(Button)findViewById(R.id.buttont);



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button();


            }
        });

    }

    protected void button() {






           Intent intent=new Intent(getApplicationContext(),MainActivity.class);
           startActivity(intent);
}



}

