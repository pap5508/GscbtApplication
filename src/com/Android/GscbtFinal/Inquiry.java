package com.Android.GscbtFinal;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.Android.GscbtDatabase.ListAdapter1;

public class Inquiry extends Activity {
	private Button home, back, search;
	private Spinner city1, bloodbank, bloodgrp;
	private ArrayAdapter inq_city, inq_bg, inq_bb;
	private ListView listContent;
	private ListAdapter1 la;
	private Cursor cursor;
	private SimpleCursorAdapter cursorAdapter;
	private TableLayout tl;
	private String sort, bg, bb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.inquiry);

		home = (Button) findViewById(R.id.inquiry_home);
		back = (Button) findViewById(R.id.inquiry_back);
		search = (Button) findViewById(R.id.inquiry_search);
		city1 = (Spinner) findViewById(R.id.inquiry_spinner);
		bloodbank = (Spinner) findViewById(R.id.inquiry_spinnerbbname);
		bloodgrp = (Spinner) findViewById(R.id.inquiry_spinnerbg);
		listContent = (ListView) findViewById(R.id.listView1_inq);
		la = new ListAdapter1(getApplicationContext());

		inq_city = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		inq_city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		city1.setAdapter(inq_city);

		city1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				city1.getAdapter().getItem(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		inq_bg = ArrayAdapter.createFromResource(this, R.array.BloodGroup,
				android.R.layout.simple_spinner_item);
		inq_bg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bloodgrp.setAdapter(inq_bg);

		bloodgrp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				bloodgrp.getAdapter().getItem(arg2).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		inq_bb = ArrayAdapter.createFromResource(this, R.array.BloodBank,
				android.R.layout.simple_spinner_item);
		inq_bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bloodbank.setAdapter(inq_bb);

		bloodbank.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				bloodbank.getAdapter().getItem(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// display search detail

				la.open();
				sort = city1.getSelectedItem().toString().trim();
				bg = bloodgrp.getSelectedItem().toString().trim();
				bb = bloodbank.getSelectedItem().toString().trim();
				cursor = la.queueAll_SortBy_CONTENT2(sort, bg, bb);
				startManagingCursor(cursor);
				// System.out.println(cursor.getString(1));
				String[] from = new String[] { ListAdapter1.KEY_ID,
						ListAdapter1.KEY_BBNAME, ListAdapter1.KEY_BBGRP,
						ListAdapter1.KEY_BBCITY, ListAdapter1.KEY_BBSTOCK };

				int[] to = new int[] { R.id.text1, R.id.text2, R.id.text3,
						R.id.text4 };

				cursorAdapter = new SimpleCursorAdapter(Inquiry.this,
						R.layout.listsearch, cursor, from, to);

				listContent.setAdapter(cursorAdapter);

			}
		});
		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// goto patient home page
				finish();
			}
		});
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// goto previous view
				finish();

			}
		});
	}

}
