package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BloodBankAdapter {

	public static final String KEY_ID = "_id";
	public static final String KEY_BBNAME = "bbname";
	public static final String KEY_BBUNAME = "bbuname";
	public static final String KEY_BBPASSWORD = "bbpassword";
	public static final String KEY_BBCPASSWORD = "bbcpassword";
	public static final String KEY_BBLICNO = "bblicno";
	public static final String KEY_BBADD = "bbadd";
	public static final String KEY_BBSTATE = "bbstate";
	public static final String KEY_BBPIN = "bbpin";
	public static final String KEY_BBPH = "bbph";
	public static final String KEY_BBEID = "bbeid";
	public static final String KEY_BBSITE = "bbsite";
	public static final String KEY_BBCATEGORY = "bbcategory";
	public static final String KEY_BBSUBCATEGORY = "bbsubcategory";
	public static final String KEY_BBCITY = "bbcity";
	public static final String KEY_BBNACO = "bbnaco";
	private static final String DATABASE_USER = "bloodbank";
	Gscbt_Helper gscbthelper;
	SQLiteDatabase sdb;
	private Context context;

	public BloodBankAdapter(Context context) {
		this.context = context;
	}

	public BloodBankAdapter open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public void close() {
		gscbthelper.close();
	}

	public long create(String bbname, String bbuname, String bbpassword,
			String bbcpassword, String bblicno, String bbadd, String bbstate,
			String bbpin, String bbph, String bbeid, String bbsite,
			String bbcategory, String bbsubcategory, String bbcity,
			String bbnaco) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_BBNAME, bbname);
		cv.put(KEY_BBUNAME, bbuname);
		cv.put(KEY_BBPASSWORD, bbpassword);
		cv.put(KEY_BBCPASSWORD, bbcpassword);
		cv.put(KEY_BBLICNO, bblicno);
		cv.put(KEY_BBADD, bbadd);
		cv.put(KEY_BBSTATE, bbstate);
		cv.put(KEY_BBPIN, bbpin);
		cv.put(KEY_BBPH, bbph);
		cv.put(KEY_BBEID, bbeid);
		cv.put(KEY_BBSITE, bbsite);
		cv.put(KEY_BBCATEGORY, bbcategory);
		cv.put(KEY_BBSUBCATEGORY, bbsubcategory);
		cv.put(KEY_BBCITY, bbcity);
		cv.put(KEY_BBNACO, bbnaco);

		return sdb.insert(DATABASE_USER, null, cv);

	}

	public Cursor verifyUser(String bbuname) {
		Cursor mCursor = sdb.query(DATABASE_USER, null, KEY_BBUNAME + "='"
				+ bbuname + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public boolean Login(String username, String password) throws SQLException {
		Cursor mCursor = sdb.rawQuery("SELECT * FROM " + DATABASE_USER
				+ " WHERE bbuname=? AND bbpassword=?", new String[] { username,
				password });
		if (mCursor != null) {
			if (mCursor.getCount() > 0) {
				return true;
			}
		}
		return false;
	}

	public int updatedata(String bbuname, String bbpassword,
			String bbcpassword, String bbadd, String bbstate, String bbpin,
			String bbph, String bbeid, String bbcategory, String bbsubcategory,
			String bbcity, String bbnaco) {
		ContentValues cv1 = new ContentValues();

		cv1.put(KEY_BBUNAME, bbuname);
		cv1.put(KEY_BBPASSWORD, bbpassword);
		cv1.put(KEY_BBCPASSWORD, bbcpassword);

		cv1.put(KEY_BBADD, bbadd);
		cv1.put(KEY_BBSTATE, bbstate);
		cv1.put(KEY_BBPIN, bbpin);
		cv1.put(KEY_BBPH, bbph);
		cv1.put(KEY_BBEID, bbeid);
		cv1.put(KEY_BBCATEGORY, bbcategory);
		cv1.put(KEY_BBSUBCATEGORY, bbsubcategory);
		cv1.put(KEY_BBCITY, bbcity);
		cv1.put(KEY_BBNACO, bbnaco);

		return sdb.update(DATABASE_USER, cv1, KEY_BBUNAME + "='" + bbuname
				+ "'", null);
	}
}
