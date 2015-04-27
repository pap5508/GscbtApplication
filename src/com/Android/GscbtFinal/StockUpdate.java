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
import android.widget.TextView;

public class StockUpdate extends Activity {

	private Button home, back, logout;
	private Spinner bloodgrp;
	private ArrayAdapter bgrp;
	ImageButton search;
	private TextView ex;
	String es, bb, bg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stockupdate);

		bloodgrp = (Spinner) findViewById(R.id.search_spinnerbgstock);

		ex = (TextView) findViewById(R.id.tv_stockuname);

		es = getIntent().getExtras().getString("uname");
		ex.setText(es);
		home = (Button) findViewById(R.id.stockupdate_home);
		back = (Button) findViewById(R.id.stockupdate_back);
		logout = (Button) findViewById(R.id.stock_logout);
		search = (ImageButton) findViewById(R.id.search_searchstock);

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
				Intent click = new Intent(getApplicationContext(),
						StockSearch.class);

				bg = bloodgrp.getSelectedItem().toString().trim();

				click.putExtra("bg", bg);
				click.putExtra("es", es);
				System.out.println(es);
				startActivity(click);
			}
		});

	}

}
