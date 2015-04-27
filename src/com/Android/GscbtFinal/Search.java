package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Search extends Activity {

	private Button home, back;
	private ImageButton search;
	private Spinner district, bloodgrp;
	private ArrayAdapter city, bgrp;
	private String sort, bg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		district = (Spinner) findViewById(R.id.search_spinner);
		bloodgrp = (Spinner) findViewById(R.id.search_spinnerbg);

		home = (Button) findViewById(R.id.search_home);
		back = (Button) findViewById(R.id.search_back);

		search = (ImageButton) findViewById(R.id.search_search);

		city = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		district.setAdapter(city);
		district.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				district.getAdapter().getItem(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		bgrp = ArrayAdapter.createFromResource(this, R.array.BloodGroup,
				android.R.layout.simple_spinner_item);
		bgrp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bloodgrp.setAdapter(bgrp);
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
				Intent selist = new Intent(getApplicationContext(),
						SearchList.class);

				sort = district.getSelectedItem().toString().trim();
				bg = bloodgrp.getSelectedItem().toString().trim();
				selist.putExtra("sort", sort);
				selist.putExtra("bg", bg);
				startActivity(selist);
			}
		});
	}

}
