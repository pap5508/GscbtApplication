package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Patient extends Activity{

	private Button reg, login, search, inquiry, back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient);
		
		reg = (Button) findViewById(R.id.patient_reg);
		login = (Button) findViewById(R.id.patient_login);
		search = (Button) findViewById(R.id.patient_search);
		inquiry = (Button) findViewById(R.id.patient_inquiry);
		back = (Button) findViewById(R.id.patient_back);

		reg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v11) {
				// goto registration view
				Intent i11 = new Intent(getApplicationContext(), Registration.class);
				String str = "Patient";
				i11.putExtra("Donor",str);
				startActivity(i11);
			}
		});

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v12) {
				// goto login view
				Intent i12 = new Intent(getApplicationContext(),Login.class);
				String str1 = "Patient";
				i12.putExtra("Donor",str1);
				startActivity(i12);
			}
		});
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v13) {
				// goto search view
				Intent i13 = new Intent(getApplicationContext(),Search.class);
				startActivity(i13);
				

			}
		});
		inquiry.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v14) {
				//goto inquiry view
				Intent i14 = new Intent(getApplicationContext(),Inquiry.class);
				startActivity(i14);
			}
		});
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v15) {
				//goto main view
				finish();
			}
		});


		
	}

}
