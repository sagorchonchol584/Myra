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

public class SmsBroadcastReceiverOwnerBilpay extends BroadcastReceiver {

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

						if (OwnerBilPay.BilPay != null) {

							((TextView) OwnerBilPay.BilPay.findViewById(R.id.textView3)).setText(msgBody);

							String alll=msgBody;
							String[] parts = alll.split(",");

							String a= parts[0];
							((TextView) OwnerBilPay.BilPay.findViewById(R.id.textView)).setText("    নামঃ- "+a);
							String b= parts[1];
							((TextView) OwnerBilPay.BilPay.findViewById(R.id.textView2)).setText("বিল নং- "+b);
							String c= parts[2];
							((TextView) OwnerBilPay.BilPay.findViewById(R.id.textView5)).setText("  টাকাঃ- "+c);
							String d= parts[3];

							String ee= parts[4];
							String f= parts[5];


							String partstwo=f;

							String sub=partstwo.substring(4, 12);
							((TextView) OwnerBilPay.BilPay.findViewById(R.id.textView4)).setText(sub);

						}
						//     Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();
					}

				}catch(Exception e){

				}
			}
		}
	}



}


