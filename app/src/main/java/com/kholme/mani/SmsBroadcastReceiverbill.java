package com.kholme.mani;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

/**
 * Created by KHOL on 10/30/2017.
 */

public class SmsBroadcastReceiverbill extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();
            SmsMessage[] msgs = null;
            String msg_from;
            if (bundle != null){

                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        String msgBody = msgs[i].getMessageBody();

                        if (Billchaking.bilmThis != null) {

                            ((TextView) Billchaking.bilmThis.findViewById(R.id.textViewtwo)).setText(msgBody);



                        }
                        //     Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();
                    }

                }catch(Exception e){

                }
            }
        }
    }}
