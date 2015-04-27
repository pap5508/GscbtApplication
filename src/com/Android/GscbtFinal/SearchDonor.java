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

public class SearchDonor extends Activity {
	private Button home, back, logout;
	private ImageButton  search;
	private Spinner bloodbank,bbsign;
	private ArrayAdapter bloodbankname,sign;
	private TextView ex;
	String es,bg,bgsign;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchdonor);
		home = (Button) findViewById(R.id.searchdonor_home);
		back = (Button) findViewById(R.id.searchdonor_back);
		search = (ImageButton) findViewById(R.id.searchbb_searchdonor);
		logout = (Button) findViewById(R.id.searchdonor_logout);
		bloodbank = (Spinner) findViewById(R.id.searchdonor_spinner);
		bbsign = (Spinner) findViewById(R.id.searchdonor_spinnersign);
		ex = (TextView) findViewById(R.id.tv_sduname);
		es = getIntent().getExtras().getString("uname");
		ex.setText(es);

		bloodbankname = ArrayAdapter.createFromResource(this, R.array.BG,
				android.R.layout.simple_spinner_item);
		bloodbankname
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bloodbank.setAdapter(bloodbankname);
		
		
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
		
		sign = ArrayAdapter.createFromResource(this, R.array.Rh,
				android.R.layout.simple_spinner_item);
		sign
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbsign.setAdapter(sign);
		
		
		bbsign.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				bbsign.getAdapter().getItem(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				finish();
			}
		});

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent sear = new Intent(getApplicationContext(),
						SearchDonorClick.class);
				bg = bloodbank.getSelectedItem().toString().trim();
				sear.putExtra("bg",bg);
				
				bgsign = bbsign.getSelectedItem().toString().trim();
				sear.putExtra("bgsign",bgsign);
				
				startActivity(sear);

			}
		});
	}

}
