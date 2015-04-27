package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DonorDetail extends Activity {

	private Button logout, profile, search, event;
	private TextView ex;
	String str12;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.donordetail);
		ex = (TextView) findViewById(R.id.tv_dpuname);
		str12 = getIntent().getExtras().getString("uname");
		ex.setText(str12);
		logout = (Button) findViewById(R.id.dp_logout);
		profile = (Button) findViewById(R.id.dp_profile);
		search = (Button) findViewById(R.id.dp_search);
		event = (Button) findViewById(R.id.dp_event);

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

				Intent prf = new Intent(getApplicationContext(), Profile.class);
				String str = "username";
				prf.putExtra("username", str12);
				startActivity(prf);
			}
		});
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v18) {
				// goto search view
				Intent srch = new Intent(getApplicationContext(),
						SearchLgn.class);
				startActivity(srch);

			}
		});
		event.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v19) {
				// goto inquiry view
				Intent i19 = new Intent(getApplicationContext(), Event.class);
				startActivity(i19);
			}
		});

	}

}
