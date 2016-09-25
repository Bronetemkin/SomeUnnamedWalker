package ru.Bronetemkin.someunnamedwalker;

import java.util.ArrayList;
import java.util.regex.Matcher;

import ru.Bronetemkin.someunnamedwalker.RegExp;
import ru.Bronetemkin.someunnamedwalker.SMSContent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLTableEditor {
	String tableName, LOG_TAG;
	public static final String REGEXPATTERNPART = "([0-9]{1,4}),? ?";
	public static final String REGEXPATTERNEND = "\\.?";
	public static final String PHONE_NUMBER = "phoneNumber";
	public String query;
	boolean bFirstTime = true;
	ArrayList<String> fieldList = new ArrayList<String>();
	SMSContent sms;
	SQLiteDatabase sql;
	String regExPattern;
	Cursor cursor;

	public SQLTableEditor(String tableName, String regExPatternBeginning) {
		this.tableName = tableName;
		regExPattern = regExPatternBeginning;
		addNewField(PHONE_NUMBER);
	}

	public void setDB(SQLiteDatabase sql) {
		this.sql = sql;
	}

	public void addNewField(String fieldName) {
		fieldList.add(fieldName);
		if (bFirstTime) {
			query = fieldName + " text not null";
			bFirstTime = false;
		} else {
			query += ", " + fieldName + " integer";
			regExPattern += REGEXPATTERNPART;
		}
	}

	public String getQuery() {
		String queryRaw = "create table " + tableName + " (" + query + ");";
		return queryRaw;
	}

	public String createPattern() {
		String regExRawPattern = regExPattern + REGEXPATTERNEND;
		return regExRawPattern;
	}

	public int setSMS(SMSContent sms) {
		this.sms = sms;
		if (!checkIsInTable(sms.getAdress())) {
			long l = sql.insert(tableName, null, readMsg());
			if (l != -1) {
				Log.d(LOG_TAG,
						"Inserted in " + tableName + ": " + sms.getContent());
				return 1;
			} else {
				Log.d(LOG_TAG,
						"Not inserted in " + tableName + ": "
								+ sms.getContent());
				return 0;
			}
		} else {
			Log.d(LOG_TAG,
					"Not inserted in " + tableName + ": " + sms.getContent());
			return 0;
		}
	}

	public boolean checkIsInTable(String adress) {
		cursor = sql.rawQuery("SELECT " + PHONE_NUMBER + " FROM " + tableName
				+ " where " + PHONE_NUMBER + " = '" + adress + "'", null);
		if (cursor.getCount() > 0)
			return true;
		else
			return false;
	}

	public ContentValues readMsg() {
		ContentValues cv = new ContentValues();
		Matcher m = RegExp.readList(sms.getBody(), createPattern());
		Log.d(LOG_TAG, createPattern());
		if (m.find()) {
			cv.put(PHONE_NUMBER, sms.getAdress());
			for (int i = 1; i < fieldList.size(); i++) {
				cv.put(fieldList.get(i), m.group(i));
			}
		}
		return cv;
	}
}
