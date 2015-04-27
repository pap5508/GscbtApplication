package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BloodBank extends Activity {

	private Button reg, login, search, event, back, home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bloodbank);

		reg = (Button) findViewById(R.id.bb_reg);
		login = (Button) findViewById(R.id.bb_login);
		search = (Button) findViewById(R.id.bb_search);
		event = (Button) findViewById(R.id.bb_event);
		back = (Button) findViewById(R.id.bb_back);
		home = (Button) findViewById(R.id.bb_home);

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// to the user section
				Intent touser = new Intent(getApplicationContext(), User.class);
				startActivity(touser);

			}
		});

		reg.setVisibility(View.GONE);
		ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = mgr.getActiveNetworkInfo();

		if (netInfo != null) {
			if (netInfo.isConnected()) {
				reg.setVisibility(View.VISIBLE);
				Toast.makeText(getApplicationContext(), "Net Connected", 1)
						.show();
				// do something

			} else {

				Toast.makeText(getApplicationContext(), "Net Not Connected", 1)
						.show();
			}
		} else {
			Toast.makeText(getApplicationContext(), "Internet Not Connected", 1)
					.show();

		}

		reg.setOnClickListener(new OnClickListener() {

			public void onClick(View v16) {
				// goto registration view

				Intent i16 = new Intent(getApplicationContext(),
						BBRegistration.class);

				startActivity(i16);
			}
		});

		login.setOnClickListener(new OnClickListener() {

			public void onClick(View v17) {
				// goto login view
				Intent i17 = new Intent(getApplicationContext(), Login.class);
				String str = "BloodBank";
				i17.putExtra("BloodBank", str);
				startActivity(i17);
			}
		});
		search.setOnClickListener(new OnClickListener() {

			public void onClick(View v18) {
				// goto search view
				Intent i17 = new Intent(getApplicationContext(), Search.class);
				startActivity(i17);

			}
		});
		event.setOnClickListener(new OnClickListener() {

			public void onClick(View v19) {
				// goto inquiry view
				Intent i17 = new Intent(getApplicationContext(), Event.class);
				startActivity(i17);

			}
		});
		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v20) {
				// goto main view
				finish();
			}
		});

	}

	/*
	 * public static boolean checkNetworkConnection(Context context) { final
	 * ConnectivityManager connMgr = (ConnectivityManager) context
	 * .getSystemService(Context.CONNECTIVITY_SERVICE);
	 * 
	 * final android.net.NetworkInfo wifi = connMgr
	 * .getNetworkInfo(ConnectivityManager.TYPE_WIFI); final
	 * android.net.NetworkInfo mobile = connMgr
	 * .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
	 * 
	 * if (wifi.isAvailable() || mobile.isAvailable()) return true; else return
	 * false; }
	 */
	/*
	 * public final boolean isOnline() { ConnectivityManager connec =
	 * (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	 * 
	 * if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
	 * connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
	 * connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
	 * connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) { //
	 * MESSAGE TO SCREEN FOR TESTING (IF REQ) // Toast.makeText(this,
	 * connectionType + ” connected”, // Toast.LENGTH_SHORT).show(); return
	 * true; } else if (connec.getNetworkInfo(0).getState() ==
	 * NetworkInfo.State.DISCONNECTED || connec.getNetworkInfo(1).getState() ==
	 * NetworkInfo.State.DISCONNECTED) { // System.out.println(“Not Connected”);
	 * return false; } return false; }
	 */
}
