package ru.Bronetemkin.someunnamedwalker;

import java.io.InputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper {
	public static final String LOG_TAG = "fs";
	public static final String DB_NAME = "Elections.db";
	public static final int DB_VERSION = 1;
	private String region_query, city_query;
	InputStream file;

	public DBHelper(Context context, String region_query, String city_query) {
		super(context, DB_NAME, null, DB_VERSION);
		this.region_query = region_query;
		this.city_query = city_query;
	}

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(region_query);
		db.execSQL(city_query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}