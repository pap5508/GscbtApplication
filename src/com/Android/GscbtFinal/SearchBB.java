package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.Android.GscbtDatabase.Json_BBAdapter;
import com.Android.GscbtDatabase.ListAdapter1;

public class SearchBB extends Activity {

	private Button home, back, logout;
	private ImageButton search;
	private Spinner bbcity;
	private ArrayAdapter city;
	private ListView listContent;
	private Json_BBAdapter la;
	private Cursor cursor;
	private SimpleCursorAdapter cursorAdapter;
	private TableLayout tl;
	private TextView ex, bb, bbno;
	String es, city1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchbb);
		bbcity = (Spinner) findViewById(R.id.searchbb_spinner);

		bb = (TextView) findViewById(R.id.bb);
		bbno = (TextView) findViewById(R.id.bbno);
		home = (Button) findViewById(R.id.searchbb_home);
		back = (Button) findViewById(R.id.searchbb_back);
		logout = (Button) findViewById(R.id.searchbb_logout);
		search = (ImageButton) findViewById(R.id.searchbb_searchbb);
		listContent = (ListView) findViewById(R.id.bbsearch_lv);
		ex = (TextView) findViewById(R.id.tv_searchbbuname);
		// bb = (TextView) findViewById(R.id.bbname);
		// bbno = (TextView) findViewById(R.id.bbno);

		bb.setVisibility(View.GONE);
		bbno.setVisibility(View.GONE);
		es = getIntent().getExtras().getString("uname");
		ex.setText(es);
		la = new Json_BBAdapter(getApplicationContext());

		city = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbcity.setAdapter(city);
		bbcity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				bbcity.getAdapter().getItem(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent lo = new Intent(getApplicationContext(), BloodBank.class);
				startActivity(lo);

			}
		});
		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View s1) {

				finish();
			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View s2) {

				finish();
			}
		});

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View s3) {

				bb.setVisibility(View.VISIBLE);
				bbno.setVisibility(View.VISIBLE);
				la.open();
				city1 = bbcity.getSelectedItem().toString().trim();
				cursor = la.queueAll_SortBy_CONTENT3(city1);
				startManagingCursor(cursor);
				// System.out.println(cursor.getString(1));
				String[] from = new String[] { Json_BBAdapter.KEY_BBNAME,
						Json_BBAdapter.KEY_BBPH };

				int[] to = new int[] { R.id.text1, R.id.text2 };

				cursorAdapter = new SimpleCursorAdapter(SearchBB.this,
						R.layout.listsearchbb, cursor, from, to);

				listContent.setAdapter(cursorAdapter);

			}
		});

	}

}
