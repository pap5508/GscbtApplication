package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BloodBankDetail extends Activity {

	private Button logout, profile, stock, event, report, search_bb,
			search_donor;
	private TextView ex;
	String str12;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bbdetail);

		logout = (Button) findViewById(R.id.bbp_logout);
		profile = (Button) findViewById(R.id.bbp_profile);
		stock = (Button) findViewById(R.id.bbp_stock);
		event = (Button) findViewById(R.id.bbp_event);

		search_bb = (Button) findViewById(R.id.bbp_searchbb);
		search_donor = (Button) findViewById(R.id.bbp_searchdonor);
		ex = (TextView) findViewById(R.id.tv_bbpuname);
		str12 = getIntent().getExtras().getString("uname");
		ex.setText(str12);

		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v16) {
				// goto bloodbank view
				finish();
			}
		});

		profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v17) {
				// goto profile view
				Intent i8 = new Intent(getApplicationContext(), BBProfile.class);
				String str = "username";
				i8.putExtra("uname", str12);
				startActivity(i8);

			}
		});
		stock.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v18) {
				// goto stock view
				Intent istock = new Intent(getApplicationContext(),
						StockUpdate.class);
				String str = "username";
				istock.putExtra("uname", str12);
				startActivity(istock);

			}
		});
		event.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v19) {
				// goto event view
				Intent ent = new Intent(getApplicationContext(), Event.class);
				String str = "username";
				ent.putExtra("uname", str12);
				startActivity(ent);

			}
		});

		search_bb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v18) {
				// goto search bloodbank view
				Intent srhbb = new Intent(getApplicationContext(),
						SearchBB.class);
				String str = "username";
				srhbb.putExtra("uname", str12);
				startActivity(srhbb);

			}
		});
		search_donor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v19) {
				// goto search donor view
				Intent srhdonor = new Intent(getApplicationContext(),
						SearchDonor.class);
				String str = "username";
				srhdonor.putExtra("uname", str12);
				startActivity(srhdonor);

			}
		});

	}

}
