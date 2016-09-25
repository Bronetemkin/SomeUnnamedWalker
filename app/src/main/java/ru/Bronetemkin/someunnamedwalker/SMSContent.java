package ru.Bronetemkin.someunnamedwalker;

import java.util.regex.Matcher;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SMSContent {
	private String adress = null;
	private String body = null;
	private String regExPattern = "\\+([0-9]{10,12})";
	Context context;
	Uri uriSms = Uri.parse("content://sms/inbox");
	Cursor smsCur;

	public SMSContent(Context context) {
		this.context = context;
		smsCur = context.getContentResolver().query(uriSms, null, null, null,
				null);
	}

	public boolean moveToNextSMS() {
		if (smsCur.moveToNext()) {
			setAdress(smsCur.getString(2));
			setBody(smsCur.getString(13));
			return true;
		} else{
			return false;
		}
	}

	public void setAdress(String adress) {
		Matcher m = RegExp.readList(adress, regExPattern);
		if (m.find()) {
			this.adress = m.group(1);
		} else {
			this.adress = adress;
		}
	}

	public String getAdress() {
		return adress;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public String getContent() {
		String content;
		content = getAdress() + ": " + getBody();
		return content;
	}
}
