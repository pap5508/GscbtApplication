package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ListAdapter1 {

	public static final String KEY_ID = "_id";
	public static final String KEY_BBNAME = "bloodbankname";
	public static final String KEY_BBGRP = "bloodgroup";
	public static final String KEY_BBCITY = "city";
	public static final String KEY_BBSTOCK = "stock";
	public static final String KEY_LAT = "lat";
	public static final String KEY_LOG = "log";
	public static final String KEY_EVENT = "event";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_STARTDATE = "startdate";
	public static final String KEY_ENDDATE = "enddate";
	public static final String KEY_ADDRESS = "address";
	public static final String KEY_PHONENO = "phoneno";
	private static final String DATABASE_LIST = "listdata";

	private Context context;
	private SQLiteDatabase sdb;
	private Gscbt_Helper gscbthelper;

	public ListAdapter1(Context context) {
		this.context = context;
	}

	public ListAdapter1 open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public void close() {
		gscbthelper.close();
	}

	public long create(String bloodbankname, String bloodgroup, String city,
			String stock, String lat, String log, String event,
			String description, String startdate, String enddate,String address,String phoneno) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_BBNAME, bloodbankname);
		cv.put(KEY_BBGRP, bloodgroup);
		cv.put(KEY_BBCITY, city);
		cv.put(KEY_BBSTOCK, stock);
		cv.put(KEY_LAT, lat);
		cv.put(KEY_LOG, log);
		cv.put(KEY_EVENT, event);
		cv.put(KEY_DESCRIPTION, description);
		cv.put(KEY_STARTDATE, startdate);
		cv.put(KEY_ENDDATE, enddate);
		cv.put(KEY_ADDRESS, address);
		cv.put(KEY_PHONENO, phoneno);
		return sdb.insert(DATABASE_LIST, null, cv);

	}

	public Cursor queueAll() {

		String[] columns = new String[] { KEY_ID, KEY_BBNAME, KEY_BBGRP,
				KEY_BBCITY, KEY_BBSTOCK, KEY_LAT, KEY_LOG, KEY_EVENT,
				KEY_DESCRIPTION, KEY_STARTDATE, KEY_ENDDATE,KEY_ADDRESS,KEY_PHONENO };

		Cursor cursor = sdb.query(DATABASE_LIST, columns, null, null, null,
				null, null);

		return cursor;

	}

	public Cursor queueAll_SortBy_CONTENT1(String City,String BG) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM listdata WHERE city=? AND bloodgroup=?",
				new String[] { City, BG});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	
	public Cursor queueAll_SortBy_CONTENT2(String City,String BG,String BB) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM listdata WHERE city=? AND bloodgroup=? AND bloodbankname=?",
				new String[] { City, BG,BB});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	
	public Cursor queueAll_SortBy_CONTENT3(String City1) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM listdata WHERE city=?  ",
				new String[] { City1});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	
	public Cursor queueAll_SortBy_CONTENT5(String BG1) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM listdata WHERE bloodgroup=?  ",
				new String[] { BG1});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	
	public Cursor queueAll_SortBy_CONTENT4(String BB1,String BG1) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM listdata WHERE bloodbankname=? AND bloodgroup=?",
				new String[] { BB1, BG1});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	
	public int updatedata(String bloodbankname, String bloodgroup,
			String stock) {
		ContentValues cv1 = new ContentValues();
		cv1.put(KEY_BBNAME, bloodbankname);
		cv1.put(KEY_BBGRP, bloodgroup);
		cv1.put(KEY_BBSTOCK, stock);
		
		return sdb.update(DATABASE_LIST, cv1, KEY_BBNAME + "='" + bloodbankname + "'",
				null);
	}

}
