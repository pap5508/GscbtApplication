package com.Android.GscbtDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Gscbt_Helper extends SQLiteOpenHelper

{

	public static String DATABASE_NAME = "GSCBT";

	private static final String DATABASE_CREATE = "create table donor (_id integer primary key autoincrement,dutype text, "
			+ "duname text, dpassword text,"
			+ "dcpassword text ,ddob text ,"
			+ "dbg text ,dcity text ,"
			+ "deid text ,dph text ,"
			+ "dstate text ,dzip text );";
	
	private static final String DATABASE_WEB_CREATE = "create table user (_id integer primary key autoincrement,userid text , "
			+ "utype text, uname text,"
			+ "password text ,dob text ,"
			+ "emailid text );";
	
	private static final String DATABASE_WEB_BLOODBANK = "create table bloodbankweb (_id integer primary key autoincrement,userid text,bbname text , "
			+ "bbaddress text ,  bbtown text ,bbdist text  ,"
			+ "bbpincode text ,bbphone text ,bbemail text ,bbwebsite text ,bblicense text ,bbcat text ,"
			+ "bbsubcat text ,bbnaco text );";

	private static final String DATABASE_WEB_DONOR_PT_REG = "create table donorreg (_id integer primary key autoincrement, "
			+ "usertype text ,  donorname text ,district text  ,"
			+ "pincode text ,datebirth text ,mobno text ,email text ,bg text,bgrh text );";

	private static final String DATABASE_WEB_BBSTOCK = "create table bbstock (_id integer primary key autoincrement,userid text , "
			+ "bg text ,  wholeblood text ,packcells text  ,"
			+ "pltlatcont text ,frsfrozen text ,stock text);";

	private static final String DATABASE_WEB_BBEVENT = "create table bbevent (_id integer primary key autoincrement,userid text , "
		+ "approved text ,  eventtitle text ,eventdesc text  ,"
		+ "startingdate text ,endingdate text);";

	
	private static final String DATABASE_BLOODBANK = "create table bloodbank (_id integer primary key autoincrement,bbname text , "
			+ "bbuname text ,  bbpassword text ,bbcpassword text  ,"
			+ "bblicno text ,bbadd text ,bbstate text ,bbpin text ,bbph text ,bbeid text ,"
			+ "bbsite text ,bbcategory text ,bbsubcategory text ,bbcity text ,bbnaco text );";

	private static final String DATABASE_LISTDATA = "create table listdata (_id integer primary key autoincrement,bloodbankname text  , "
			+ "bloodgroup text  ,  city text  ,stock text , lat text,log text , event text, description text, startdate text, enddate text,address text,phoneno text);";

	public Gscbt_Helper(Context context) {
		super(context, DATABASE_NAME, null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_CREATE);

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_WEB_CREATE);

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_WEB_BLOODBANK);

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_WEB_DONOR_PT_REG);

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_WEB_BBSTOCK);

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_WEB_BBEVENT);
		
		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_BLOODBANK);

		Log.i("Helper", "Creating Table");
		db.execSQL(DATABASE_LISTDATA);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}
