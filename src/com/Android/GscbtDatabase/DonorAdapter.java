package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DonorAdapter {

	public static final String KEY_ID = "_id";
	public static final String KEY_DTYPE = "dutype";
	public static final String KEY_DUNAME = "duname";
	public static final String KEY_DPASSWORD = "dpassword";
	public static final String KEY_DCPASSWORD = "dcpassword";
	public static final String KEY_DDOB = "ddob";
	public static final String KEY_DBG = "dbg";
	public static final String KEY_DEID = "deid";
	public static final String KEY_DPH = "dph";
	public static final String KEY_DCITY = "dcity";
	public static final String KEY_DSTATE = "dstate";
	public static final String KEY_DZIP = "dzip";
	private static final String DATABASE_USER = "donor";
	private Context context;
	private SQLiteDatabase sdb;
	private Gscbt_Helper gscbthelper;

	public DonorAdapter(Context context) {
		this.context = context;
	}

	public DonorAdapter open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public void close() {
		gscbthelper.close();
	}

	public long create(String dutype, String duname, String dpassword,
			String dcpassword, String ddob, String dbg, String dcity,
			String deid, String dph, String dstate, String dzip) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_DTYPE, dutype);
		cv.put(KEY_DUNAME, duname);
		cv.put(KEY_DPASSWORD, dpassword);
		cv.put(KEY_DCPASSWORD, dcpassword);
		cv.put(KEY_DDOB, ddob);
		cv.put(KEY_DBG, dbg);
		cv.put(KEY_DCITY, dcity);

		cv.put(KEY_DEID, deid);
		cv.put(KEY_DPH, dph);
		cv.put(KEY_DSTATE, dstate);
		cv.put(KEY_DZIP, dzip);
		return sdb.insert(DATABASE_USER, null, cv);

	}

	public Cursor verifyUser(String duname) {
		Cursor mCursor = sdb.query(DATABASE_USER, null, KEY_DUNAME + "='"
				+ duname + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	/*
	 * public Cursor verifyUserType(String dutype) { Cursor mCursor =
	 * sdb.query(DATABASE_USER, null, KEY_DTYPE + "='" + dutype + "'", null,
	 * null, null, null, null); if (mCursor != null) { mCursor.moveToFirst(); }
	 * return mCursor; }
	 */

	public boolean Login(String usertype, String username, String password)
			throws SQLException {
		Cursor mCursor = sdb.rawQuery("SELECT * FROM " + DATABASE_USER
				+ " WHERE dutype=? AND duname=? AND dpassword=?", new String[] {
				usertype, username, password });
		if (mCursor != null) {
			if (mCursor.getCount() > 0) {
				return true;
			}
		}
		return false;
	}

	public Cursor queueAll() {

		String[] columns = new String[] {KEY_DUNAME,KEY_DPASSWORD,KEY_DCITY,KEY_DSTATE,KEY_DZIP,KEY_DPH};

		Cursor cursor = sdb.query(DATABASE_USER, columns, null, null, null,
				null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;

	}

	public int updatedata(String duname, String dpassword, String dcpassword,
			String dcity, String deid, String dph, String dstate, String dzip) {
		ContentValues cv1 = new ContentValues();

		cv1.put(KEY_DUNAME, duname);
		cv1.put(KEY_DPASSWORD, dpassword);
		cv1.put(KEY_DCPASSWORD, dcpassword);

		cv1.put(KEY_DCITY, dcity);

		cv1.put(KEY_DEID, deid);
		cv1.put(KEY_DPH, dph);
		cv1.put(KEY_DSTATE, dstate);
		cv1.put(KEY_DZIP, dzip);

		return sdb.update(DATABASE_USER, cv1, KEY_DUNAME + "='" + duname + "'",
				null);
	}
}
