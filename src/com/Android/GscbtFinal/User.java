package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class User extends Activity {

	private Button donor, patient, bb, exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.user);
		donor = (Button) findViewById(R.id.user_donor);
		patient = (Button) findViewById(R.id.user_patient);
		bb = (Button) findViewById(R.id.user_bb);
		exit = (Button) findViewById(R.id.user_back);

		donor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v1) {
				// go to donor view
				Intent i1 = new Intent(getApplicationContext(), Donor.class);
				startActivity(i1);
			}
		});

		patient.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v2) {
				// go to patient view

				Intent i2 = new Intent(getApplicationContext(), Patient.class);
				startActivity(i2);
			}
		});
		bb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v3) {
				// go to bloodbank view
				Intent i3 = new Intent(getApplicationContext(), BloodBank.class);
				startActivity(i3);

			}
		});
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v3) {
				// go to bloodbank view
				Intent i3 = new Intent(getApplicationContext(),
						GSCBTFINALActivity.class);
				startActivity(i3);

			}
		});

	}
}
