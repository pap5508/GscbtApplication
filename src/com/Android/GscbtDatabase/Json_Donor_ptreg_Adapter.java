package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Json_Donor_ptreg_Adapter {

	public static final String KEY_ID = "_id";
	public static final String KEY_UTYPE = "usertype";
	public static final String KEY_DNAME = "donorname";
	public static final String KEY_DIST = "district";
	public static final String KEY_PIN = "pincode";
	public static final String KEY_DOB = "datebirth";
	public static final String KEY_MOBNO = "mobno";
	public static final String KEY_EID = "email";
	public static final String KEY_BG = "bg";
	public static final String KEY_BGRH = "bgrh";

	private static final String DATABASE_DONOR = "donorreg";
	Gscbt_Helper gscbthelper;
	SQLiteDatabase sdb;
	private Context context;

	public Json_Donor_ptreg_Adapter(Context context) {
		this.context = context;
	}

	public Json_Donor_ptreg_Adapter open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public void close() {
		gscbthelper.close();
	}

	public int deleteAll() {
		return sdb.delete(DATABASE_DONOR, null, null);
	}

	public long create(String usertype, String donorname, String district,
			String pincode, String datebirth, String mobno, String email,
			String bg, String bgrh) {
		ContentValues cv = new ContentValues();

		cv.put(KEY_UTYPE, usertype);
		cv.put(KEY_DNAME, donorname);
		cv.put(KEY_DIST, district);
		cv.put(KEY_PIN, pincode);
		cv.put(KEY_DOB, datebirth);
		cv.put(KEY_MOBNO, mobno);
		cv.put(KEY_EID, email);
		cv.put(KEY_BG, bg);
		cv.put(KEY_BGRH, bgrh);

		return sdb.insert(DATABASE_DONOR, null, cv);

	}

	public boolean Login(String utype, String username, String pwdy)
			throws SQLException {
		Cursor mCursor = sdb
				.rawQuery(
						"SELECT * FROM donorreg a JOIN user b ON a.donorname = b.uname WHERE usertype=? AND donorname=? AND password=?",
						new String[] { utype, username, pwdy });
		if (mCursor != null) {
			if (mCursor.getCount() > 0) {
				return true;
			}
		}

		return false;
	}

	public long create(String userid, String usertype, String donorname,
			String district, String pincode, String datebirth, String mobno,
			String email, String bg, String bgrh) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, userid);
		cv.put(KEY_UTYPE, usertype);
		cv.put(KEY_DNAME, donorname);
		cv.put(KEY_DIST, district);
		cv.put(KEY_PIN, pincode);
		cv.put(KEY_DOB, datebirth);
		cv.put(KEY_MOBNO, mobno);
		cv.put(KEY_EID, email);
		cv.put(KEY_BG, bg);
		cv.put(KEY_BGRH, bgrh);

		return sdb.insert(DATABASE_DONOR, null, cv);

	}

	public Cursor verifyUser(String donorname) {
		Cursor mCursor = sdb.query(DATABASE_DONOR, null, KEY_DNAME + "='"
				+ donorname + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor queueAll() {

		String[] columns = new String[] { KEY_ID, KEY_DNAME, KEY_DIST, KEY_PIN,
				KEY_MOBNO, KEY_EID };

		Cursor cursor = sdb.query(DATABASE_DONOR, columns, null, null, null,
				null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;

	}

	public int updatedata(String donorname, String district, String pincode,
			String mobno, String email) {
		ContentValues cv1 = new ContentValues();

		cv1.put(KEY_DNAME, donorname);
		cv1.put(KEY_DIST, district);
		cv1.put(KEY_PIN, pincode);
		cv1.put(KEY_MOBNO, mobno);
		cv1.put(KEY_EID, email);

		return sdb.update(DATABASE_DONOR, cv1, KEY_DNAME + "='" + donorname
				+ "'", null);
	}

	public Cursor queueAll_SortBy_CONTENT3(String bg1) {

		Cursor c1 = sdb.rawQuery(
				"SELECT * FROM donorreg WHERE bg=?", new String[] {
						bg1});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}

}
