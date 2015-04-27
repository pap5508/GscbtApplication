package com.Android.GscbtDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Json_BBAdapter {

	public static final String KEY_ID = "_id";
	public static final String KEY_BBUID = "userid";
	public static final String KEY_BBNAME = "bbname";
	public static final String KEY_BBADD = "bbaddress";
	public static final String KEY_BBTOWN = "bbtown";
	public static final String KEY_BBDIST = "bbdist";
	public static final String KEY_BBPIN = "bbpincode";
	public static final String KEY_BBPH = "bbphone";
	public static final String KEY_BBEMAIL = "bbemail";
	public static final String KEY_BBWEB = "bbwebsite";
	public static final String KEY_BBLICE = "bblicense";

	public static final String KEY_BBCAT = "bbcat";
	public static final String KEY_BBSUBCAT = "bbsubcat";

	public static final String KEY_BBNACO = "bbnaco";
	private static final String DATABASE_BB = "bloodbankweb";
	Gscbt_Helper gscbthelper;
	SQLiteDatabase sdb;
	private Context context;

	public Json_BBAdapter(Context context) {
		this.context = context;
	}

	public Json_BBAdapter open() throws SQLException {
		gscbthelper = new Gscbt_Helper(context);
		sdb = gscbthelper.getWritableDatabase();
		return this;
	}

	public int deleteAll() {
		return sdb.delete(DATABASE_BB, null, null);
	}

	public void close() {
		gscbthelper.close();
	}

	public long create(String userid, String bbname, String bbaddress,
			String bbtown, String bbdist, String bbpincode, String bbphone,
			String bbemail, String bbwebsite, String bblicense, String bbcat,
			String bbsubcat, String bbnaco) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_BBUID, userid);
		cv.put(KEY_BBNAME, bbname);
		cv.put(KEY_BBADD, bbaddress);
		cv.put(KEY_BBTOWN, bbtown);
		cv.put(KEY_BBDIST, bbdist);
		cv.put(KEY_BBPIN, bbpincode);
		cv.put(KEY_BBPH, bbphone);
		cv.put(KEY_BBEMAIL, bbemail);
		cv.put(KEY_BBWEB, bbwebsite);
		cv.put(KEY_BBLICE, bblicense);
		cv.put(KEY_BBCAT, bbcat);
		cv.put(KEY_BBSUBCAT, bbsubcat);
		cv.put(KEY_BBNACO, bbnaco);

		return sdb.insert(DATABASE_BB, null, cv);

	}

	public Cursor queueAll() {

		String[] columns = new String[] { KEY_BBUID, KEY_BBNAME, KEY_BBADD,
				KEY_BBTOWN, KEY_BBDIST, KEY_BBPIN, KEY_BBPH, KEY_BBEMAIL,
				KEY_BBWEB, KEY_BBLICE };

		Cursor cursor = sdb.query(DATABASE_BB, columns, null, null, null, null,
				null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;

	}

	public Cursor queueAll_SortBy_CONTENT_CITY(String City,String BG) {

		Cursor c1 = sdb
				.rawQuery(
						"SELECT * FROM bloodbankweb a JOIN bbstock b ON a.userid=b.userid WHERE a.bbdist=? AND b.bg=?",
						new String[] { City,BG });
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	
	
	
	public Cursor queueAll_SortBy_CONTENT3(String City1) {

		Cursor c1 = sdb.rawQuery("SELECT * FROM bloodbankweb WHERE bbdist=?  ",
				new String[] { City1});
		if (c1 != null) {
			if (c1.getCount() > 0) {
				return c1;
			}
		}
		return c1;

	}
	

	 public boolean Login(String username, String password) throws SQLException  
	    {  
	        Cursor mCursor = sdb.rawQuery("SELECT * FROM " + DATABASE_BB + " WHERE bbuname=? AND bbpassword=?", new String[]{username,password});  
	        if (mCursor != null) {  
	            if(mCursor.getCount() > 0)  
	            {  
	                return true;  
	            }  
	        }  
	     return false;  
	    }  
	 
	 public int updatedata(String bbname,
				String bbadd,String bbph,String bbemail,
				String bbcategory,String bbsubcategory,String bbdist,String bbnaco) {
			ContentValues cv1 = new ContentValues();

			cv1.put(KEY_BBNAME,bbname);
			cv1.put(KEY_BBADD,bbadd);
			cv1.put(KEY_BBPH,bbph);
			cv1.put(KEY_BBEMAIL,bbemail);
			cv1.put(KEY_BBCAT,bbcategory);
			cv1.put(KEY_BBSUBCAT,bbsubcategory);
			cv1.put(KEY_BBDIST,bbdist);
			cv1.put(KEY_BBNACO,bbnaco);
			
			

			return sdb.update(DATABASE_BB, cv1, KEY_BBNAME + "='" + bbname + "'",
					null);
		}
	 
	 
}
