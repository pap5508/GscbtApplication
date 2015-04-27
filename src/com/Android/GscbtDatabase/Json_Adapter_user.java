package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Json_Adapter_user {

	public static final String KEY_ID = "_id";
	public static final String KEY_UID = "userid";
	public static final String KEY_UTYPE = "utype";
	public static final String KEY_UNAME = "uname";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_DOB = "dob";
	public static final String KEY_EID = "emailid";

	private static final String DATABASE_USER = "user";
	private Context context;
	private SQLiteDatabase sdb;
	private Gscbt_Helper jsonhelper;

	public Json_Adapter_user(Context context) {
		this.context = context;
	}

	public Json_Adapter_user open() throws SQLException {
		jsonhelper = new Gscbt_Helper(context);
		sdb = jsonhelper.getWritableDatabase();
		return this;
	}

	public int deleteAll() {
		return sdb.delete(DATABASE_USER, null, null);
	}

	public void close() {
		jsonhelper.close();
	}

	public long createuser(String userid, String utype, String uname,
			String password, String dob, String emailid) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_UID, userid);
		cv.put(KEY_UTYPE, utype);
		cv.put(KEY_UNAME, uname);
		cv.put(KEY_PASSWORD, password);
		cv.put(KEY_DOB, dob);
		cv.put(KEY_EID, emailid);
		return sdb.insert(DATABASE_USER, null, cv);

	}

	public long createuser(String utype, String uname, String password,
			String dob, String emailid) {
		ContentValues cv = new ContentValues();

		cv.put(KEY_UTYPE, utype);
		cv.put(KEY_UNAME, uname);
		cv.put(KEY_PASSWORD, password);
		cv.put(KEY_DOB, dob);
		cv.put(KEY_EID, emailid);
		return sdb.insert(DATABASE_USER, null, cv);

	}

	public long create(String userid, String utype, String uname,
			String password, String emailid) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_UTYPE, utype);
		cv.put(KEY_UNAME, uname);
		cv.put(KEY_PASSWORD, password);
		cv.put(KEY_EID, emailid);
		return sdb.insert(DATABASE_USER, null, cv);

	}

	public int updatedata(String uname, String password, String emailid) {
		ContentValues cv1 = new ContentValues();

		cv1.put(KEY_UNAME, uname);
		cv1.put(KEY_PASSWORD, password);

		cv1.put(KEY_EID, emailid);

		return sdb.update(DATABASE_USER, cv1, KEY_UNAME + "='" + uname + "'",
				null);
	}

	public Cursor queueAll() {

		String[] columns = new String[] { KEY_UTYPE, KEY_UNAME, KEY_PASSWORD,
				KEY_DOB, KEY_EID };

		Cursor cursor = sdb.query(DATABASE_USER, columns, null, null, null,
				null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;

	}

	public Cursor verifyUser(String uname) {
		Cursor mCursor = sdb.query(DATABASE_USER, null, KEY_UNAME + "='"
				+ uname + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public boolean Login(String username, String pwdy) throws SQLException {
		Cursor mCursor = sdb.rawQuery(
				"SELECT * FROM user WHERE  uname=? AND password=?",
				new String[] { username, pwdy });
		if (mCursor != null) {
			if (mCursor.getCount() > 0) {
				return true;
			}
		}

		return false;
	}

}
