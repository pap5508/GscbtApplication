package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PatientDetail extends Activity {

	private Button logout, profile, search, inquiry;
	String str12;
	private TextView ex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientdetail);

		logout = (Button) findViewById(R.id.pp_logout);
		profile = (Button) findViewById(R.id.pp_profile);
		search = (Button) findViewById(R.id.pp_search);
		inquiry = (Button) findViewById(R.id.pp_inquiry);
		ex = (TextView) findViewById(R.id.tv_ppuname);
		str12 = getIntent().getExtras().getString("uname");
		ex.setText(str12);

		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v16) {
				// goto patient view
				Intent lgout = new Intent(getApplicationContext(),
						GSCBTFINALActivity.class);
				startActivity(lgout);
			}
		});

		profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v17) {
				// goto patient profile view
				Intent ptprf = new Intent(getApplicationContext(),
						Profile.class);
				String str = "username";
				ptprf.putExtra("username", str12);
				startActivity(ptprf);
			}
		});
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v18) {
				// goto search view
				Intent ptsrch = new Intent(getApplicationContext(),
						SearchLgn.class);
				startActivity(ptsrch);
			}
		});
		inquiry.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v19) {
				// goto inquiry view
				Intent ptinqry = new Intent(getApplicationContext(),
						Inquiry.class);
				startActivity(ptinqry);
			}
		});

	}

}
