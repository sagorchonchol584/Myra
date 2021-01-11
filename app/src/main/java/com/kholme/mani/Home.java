package com.kholme.mani;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
      TextView t;
    Button LogInButton, RegisterButton ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LogInButton = (Button)findViewById(R.id.buttonLogin);

        RegisterButton = (Button)findViewById(R.id.buttonRegister);
        t = (TextView) findViewById(R.id.textView);
        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);

        sqLiteHelper = new SQLiteHelper(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();


            }
        });

//---------------------------------------------------------------------------------------------------
//        // Adding click listener to register button.

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //   Opening new user registration activity using intent on button click.

                i++;
                      if(i==5){

                            Intent intent = new Intent(Home.this, RegisterActivity.class);
                            startActivity(intent);


                      }else {

                          Toast.makeText(Home.this,"দয়া করে ব্যবহার নাম বা পাসওয়ার্ড  দেখুন..",Toast.LENGTH_LONG).show();

                      }

            }
        });

    //----------------------------------------------------------------------------------------------




    }





    // Login function starts from here.
    public void LoginFunction(){

        if(EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(Home.this,"দয়া করে ব্যবহার নাম বা পাসওয়ার্ড  দেখুন..",Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {

            Toast.makeText(Home.this,"লগইন সম্পূর্ন হয়েছে..",Toast.LENGTH_LONG).show();

            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(Home.this, MainActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(UserEmail, EmailHolder);

            startActivity(intent);


        }
        else {

            Toast.makeText(Home.this,"ব্যবহার নাম বা পাসওয়ার্ড ভুল। আবার চেষ্টা করুন...",Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND" ;

    }




}
