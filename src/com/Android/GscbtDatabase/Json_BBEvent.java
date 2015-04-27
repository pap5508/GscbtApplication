package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Json_BBEvent {

	public static final String KEY_ID = "_id";
	public static final String KEY_UID = "userid";
	public static final String KEY_APPROVED = "approved";
	public static final String KEY_EVENTTITLE = "eventtitle";
	public static final String KEY_EVENTDESC = "eventdesc";
	public static final String KEY_SDATE = "startingdate";
	public static final String KEY_EDATE = "endingdate";

	private static final String DATABASE_BBEVENT = "bbevent";
	Gscbt_Helper gscbthelper;
	SQLiteDatabase sdb;
	private Context context;

	public Json_BBEvent(Context context) {
		this.context = context;
	}

	public Json_BBEvent open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public void close() {
		gscbthelper.close();
	}

	public long create(String userid, String approved, String eventtitle,
			String eventdesc, String startingdate, String endingdate) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_UID, userid);
		cv.put(KEY_APPROVED, approved);
		cv.put(KEY_EVENTTITLE, eventtitle);
		cv.put(KEY_EVENTDESC, eventdesc);
		cv.put(KEY_SDATE, startingdate);
		cv.put(KEY_EDATE, endingdate);

		return sdb.insert(DATABASE_BBEVENT, null, cv);

	}

	public Cursor queueAll() {

		String[] columns = new String[] {KEY_ID, KEY_UID, KEY_APPROVED,
				KEY_EVENTTITLE, KEY_EVENTDESC, KEY_SDATE, KEY_EDATE };

		Cursor cursor = sdb.query(DATABASE_BBEVENT, columns, null, null, null,
				null, null);

		return cursor;

	}
	
	public int deleteAll(){
		 return sdb.delete(DATABASE_BBEVENT, null, null);
		}
}
