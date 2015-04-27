package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Json_BBStock {

	public static final String KEY_ID = "_id";
	public static final String KEY_UID = "userid";
	public static final String KEY_BG = "bg";
	public static final String KEY_WHOLEBLOOD = "wholeblood";
	public static final String KEY_PACKCELL = "packcells";
	public static final String KEY_PLT = "pltlatcont";
	public static final String KEY_FRS = "frsfrozen";
	public static final String KEY_STOCK = "stock";

	private static final String DATABASE_BBSTOCK = "bbstock";
	Gscbt_Helper gscbthelper;
	SQLiteDatabase sdb;
	private Context context;

	public Json_BBStock(Context context) {
		this.context = context;
	}

	public Json_BBStock open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public int deleteAll() {
		return sdb.delete(DATABASE_BBSTOCK, null, null);
	}

	public void close() {
		gscbthelper.close();
	}

	public long create(String userid, String bg, String wholeblood,
			String packcells, String pltlatcont, String frsfrozen, String stock) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_UID, userid);
		cv.put(KEY_BG, bg);
		cv.put(KEY_WHOLEBLOOD, wholeblood);
		cv.put(KEY_PACKCELL, packcells);
		cv.put(KEY_PLT, pltlatcont);
		cv.put(KEY_FRS, frsfrozen);
		cv.put(KEY_STOCK, stock);

		return sdb.insert(DATABASE_BBSTOCK, null, cv);

	}

	public Cursor queueAll() {

		String[] columns = new String[] { KEY_UID, KEY_BG, KEY_WHOLEBLOOD,
				KEY_PACKCELL, KEY_PLT, KEY_FRS, KEY_STOCK };

		Cursor cursor = sdb.query(DATABASE_BBSTOCK, columns, null, null, null,
				null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;

	}

	public Cursor queueAll_SortBy_CONTENT_BG(String BG) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM bbstock WHERE bg=? ",
				new String[] { BG });
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}

	public Cursor queueAll_SortBy_CONTENT_BG1(String BG, String UNAME) {

		Cursor c1 = sdb
				.rawQuery(
						"SELECT * FROM bbstock a JOIN user b ON b.userid=a.userid WHERE a.bg = ? AND b.uname=?",
						new String[] { BG, UNAME });
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}

	public int updatedata(String uid, String wholeblood, String packcells,
			String pltlatcont) {
		ContentValues cv1 = new ContentValues();
		cv1.put(KEY_ID, uid);
	
		cv1.put(KEY_WHOLEBLOOD, wholeblood);
		cv1.put(KEY_PACKCELL, packcells);
		cv1.put(KEY_PLT, pltlatcont);

		return sdb.update(DATABASE_BBSTOCK, cv1, KEY_ID + "='" + uid + "'",
				null);
	}

}
