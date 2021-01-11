package com.kholme.mani;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

/**
 * Created by KHOL on 11/4/2017.
 */

public class SmsBroadcastReceiverone extends BroadcastReceiver {

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

                        if (itemtwo.two != null) {

                           ((TextView) itemtwo.two.findViewById(R.id.textView3)).setText(msgBody);
                            String alll=msgBody;
   //                         String[] parts = alll.split(",");
//
//                            String a= parts[0];
//
//                            String b= parts[1];
//
//                            String c= parts[2];
//
//                            String d= parts[3];
//
//
//
//
//                            String partstwo=d;
//
//                            String sub=partstwo.substring(6, 23);
                            ((TextView) itemtwo.two.findViewById(R.id.textView4)).setText(alll);
                        }
                      //  Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();
                    }

                }catch(Exception e){

                }
            }
        }
    }



}
