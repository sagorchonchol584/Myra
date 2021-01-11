package com.kholme.mani;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

/**
 * Created by CHON on 1/20/2018.
 */
public class SmsBroadcastReceiverOwnerBilpapd extends BroadcastReceiver {
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

						if (OwnerbilPaid.ownerpaid != null) {

							((TextView) OwnerbilPaid.ownerpaid.findViewById(R.id.textViewtwo)).setText(msgBody);



						}
						//     Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();
					}

				}catch(Exception e){

				}
			}
		}
	}}

