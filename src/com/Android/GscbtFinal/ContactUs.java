package com.Android.GscbtFinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ContactUs extends Activity {

	private TextView address, phone, fax, email, website;
	private Button back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactus);

		address = (TextView) findViewById(R.id.tv_addv);
		phone = (TextView) findViewById(R.id.tv_phv);
		fax = (TextView) findViewById(R.id.tv_faxv);
		email = (TextView) findViewById(R.id.tv_eidv);
		website = (TextView) findViewById(R.id.tv_sitev);
		back = (Button) findViewById(R.id.contact_back);

		address.setText("     O-1 Block, New Mental Hospital" + "\n"
				+ "     Complex,Meghaninager,Ahmedabad 380016.");

		phone.setText("     079-22685210,22680211-12-13");

		fax.setText("     079-22680214");

		email.setText("     gscbt.gov@gmail.com");

		website.setText("     www.gscbt.co.in");

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v21) {
				// goto main view
				finish();
			}
		});
	}

}
