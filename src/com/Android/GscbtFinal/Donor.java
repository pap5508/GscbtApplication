package com.Android.GscbtFinal;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Donor extends Activity {

	private Button reg, login, search, event, back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.donor);

		reg = (Button) findViewById(R.id.donor_reg);
		login = (Button) findViewById(R.id.donor_login);
		search = (Button) findViewById(R.id.donor_search);
		event = (Button) findViewById(R.id.donor_event);
		back = (Button) findViewById(R.id.donor_back);

		reg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v6) {
				// goto registration view
				Intent i6 = new Intent(getApplicationContext(),
						Registration.class);
				String str = "Donor";
				i6.putExtra("Donor", str);
				startActivity(i6);
			}
		});

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v7) {
				// goto login view
				Intent i7 = new Intent(getApplicationContext(), Login.class);
				String str = "Donor";
				i7.putExtra("Donor", str);
				startActivity(i7);
			}
		});
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v8) {
				// goto search view
				Intent i8 = new Intent(getApplicationContext(),
						Search.class);
				startActivity(i8);
			}
		});
		event.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v9) {
				// goto event view
				Intent eventsearch = new Intent(getApplicationContext(),
						Event.class);
				startActivity(eventsearch);

			}
		});
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v10) {
				// goto main view
				Intent bk = new Intent(getApplicationContext(),
						User.class);
				startActivity(bk);
			}
		});

	}

}
