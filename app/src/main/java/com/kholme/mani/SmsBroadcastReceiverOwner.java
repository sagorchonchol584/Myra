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

public class SmsBroadcastReceiverOwner extends BroadcastReceiver {

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

						if (Owner.ownersms != null) {

							//((TextView) Owner.ownersms.findViewById(R.id.textViewowner)).setText(msgBody);

							String alll=msgBody;
							String[] parts = alll.split(",");

							String a= parts[0];
						//	((TextView) Owner.ownersms.findViewById(R.id.textView)).setText("    নামঃ- "+a);
							String b= parts[1];
						//	((TextView) Owner.ownersms.findViewById(R.id.textView2)).setText("বিল নং- "+b);
							String c= parts[2];
						//	((TextView) Owner.ownersms.findViewById(R.id.textView5)).setText("  টাকাঃ- "+c);
							String d= parts[3];




							String sub=d.substring(5,12);
							((TextView) Owner.ownersms.findViewById(R.id.textViewowner)).setText(sub);

						}
						//     Toast.makeText(context, msgBody, Toast.LENGTH_LONG).show();
					}

				}catch(Exception e){

				}
			}
		}
	}



}

