package com.Android.GscbtFinal;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Android.GscbtDatabase.DonorAdapter;
import com.Android.GscbtDatabase.Json_Adapter_user;
import com.Android.GscbtDatabase.Json_Donor_ptreg_Adapter;

public class Profile extends Activity {

	private EditText uname, pwd, cpwd, eid1, ph, zip;
	private Spinner city;
	private Button home, cancel, update, logout;
	Json_Donor_ptreg_Adapter da;
	Json_Adapter_user userprfl;
	TextView profile;
	ArrayAdapter cityadap1;
	String str12p, str126p;

	private Cursor cursor;
	private String username, userpwd, usercpwd, usereid, userph, userstate,
			userzip, usercity;
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		uname = (EditText) findViewById(R.id.profile_uname);
		str126p = getIntent().getExtras().getString("username");
		uname.setText(str126p);
		pwd = (EditText) findViewById(R.id.profile_pwd);
		cpwd = (EditText) findViewById(R.id.profile_cpwd);
		eid1 = (EditText) findViewById(R.id.profile_eid);
		ph = (EditText) findViewById(R.id.profile_ph);
		city = (Spinner) findViewById(R.id.profile_cityspinner);

		zip = (EditText) findViewById(R.id.profile_zip);
		home = (Button) findViewById(R.id.profile_home);
		update = (Button) findViewById(R.id.profile_update);
		logout = (Button) findViewById(R.id.profile_logout);

		cancel = (Button) findViewById(R.id.profile_cancel);
		da = new Json_Donor_ptreg_Adapter(getApplicationContext());
		userprfl = new Json_Adapter_user(getApplicationContext());

		profile = (TextView) findViewById(R.id.tv_puname);
		str12p = getIntent().getExtras().getString("username");
		profile.setText(str12p);
		cityadap1 = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		cityadap1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		city.setAdapter(cityadap1);
		city.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				usercity = city.getItemAtPosition(position).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}

		});

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v22) {
				// goto main page
				finish();
			}
		});

		update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v23) {
				da.open();
				userprfl.open();
				da.queueAll();
				username = uname.getText().toString();
				System.out.println(username);
				userpwd = pwd.getText().toString();
				usercpwd = cpwd.getText().toString();

				usereid = eid1.getText().toString();
				userph = ph.getText().toString();
				userzip = zip.getText().toString();

				uname.setText(username);

				da.updatedata(username, usercity, userzip, userph, usereid);
				userprfl.updatedata(username, userpwd, usereid);
				uname.setText("");
				pwd.setText("");
				cpwd.setText("");
				eid1.setText("");
				ph.setText("");
				zip.setText("");
				da.close();
			
				Toast.makeText(getApplicationContext(), "User Data Successfully Updated", Toast.LENGTH_LONG).show();
			}
		});

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v24) {
				// goto main page

				pwd.setText("");
				cpwd.setText("");
				eid1.setText("");
				ph.setText("");
				zip.setText("");
			}
		});
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View helo) {
				Intent lgout = new Intent(getApplicationContext(),
						GSCBTFINALActivity.class);
				startActivity(lgout);
			}
		});
	}
}