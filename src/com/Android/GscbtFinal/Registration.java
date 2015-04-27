package com.Android.GscbtFinal;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_Adapter_user;
import com.Android.GscbtDatabase.Json_Donor_ptreg_Adapter;

public class Registration extends Activity {

	private EditText utype, uname, pwd, cpwd, dob, eid, ph, zip;
	static final int DATE_DIALOG_ID = 1;
	private int year, month, day;
	private Spinner city, bloodgrp, bloodgrpsign;
	private Button home, submit, cancel;
	ArrayAdapter<?> cityadap, bloodadap, bloodsignadap;
	Json_Donor_ptreg_Adapter donoradapter;
	Json_Adapter_user userlogin;
	Cursor cursor;

	private String userid,usertype, username, userpwd, usercpwd, userdob, usereid,
			userph, userzip, usercity, userbloodgrp, userbgsign;
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		utype = (EditText) findViewById(R.id.reg_utype);
		String str;
		str = getIntent().getExtras().getString("Donor");
		utype.setText(str);
		
		donoradapter = new Json_Donor_ptreg_Adapter(getApplicationContext());
		userlogin = new Json_Adapter_user(getApplicationContext());
		
		uname = (EditText) findViewById(R.id.reg_uname);
		pwd = (EditText) findViewById(R.id.reg_pwd);
		cpwd = (EditText) findViewById(R.id.reg_cpwd);
		dob = (EditText) findViewById(R.id.reg_dob);
		eid = (EditText) findViewById(R.id.reg_eid);
		ph = (EditText) findViewById(R.id.reg_ph);
		bloodgrp = (Spinner) findViewById(R.id.reg_bgspinner);
		city = (Spinner) findViewById(R.id.reg_cityspinner);
		bloodgrpsign = (Spinner) findViewById(R.id.reg_bgspinner_ve);

		zip = (EditText) findViewById(R.id.reg_zip);
		home = (Button) findViewById(R.id.reg_home);
		submit = (Button) findViewById(R.id.reg_submit);
		cancel = (Button) findViewById(R.id.reg_cancel);

		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(dob.getWindowToken(), 0);

		cityadap = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		cityadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		city.setAdapter(cityadap);
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

		bloodadap = ArrayAdapter.createFromResource(this, R.array.BG,
				android.R.layout.simple_spinner_item);
		bloodadap
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bloodgrp.setAdapter(bloodadap);
		bloodgrp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				userbloodgrp = bloodgrp.getItemAtPosition(pos).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		bloodsignadap = ArrayAdapter.createFromResource(this, R.array.Rh,
				android.R.layout.simple_spinner_item);
		bloodsignadap
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bloodgrpsign.setAdapter(bloodsignadap);
		bloodgrpsign.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				userbgsign = bloodgrpsign.getItemAtPosition(pos).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		dob.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showDialog(DATE_DIALOG_ID);

			}
		});
		final Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);

		updateDate();

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v22) {
				// goto main page
				finish();
			}
		});

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v23) {

				usertype = utype.getText().toString();
				username = uname.getText().toString();
				userpwd = pwd.getText().toString();
				usercpwd = cpwd.getText().toString();
				userdob = dob.getText().toString();
				usereid = eid.getText().toString();
				userph = ph.getText().toString();

				userzip = zip.getText().toString();
				
				donoradapter.open();
				userlogin.open();
				
				cursor = donoradapter.verifyUser(username);

				if (username.equals("") || userpwd.equals("")
						|| usercpwd.equals("") || userdob.equals("")
						|| userbloodgrp.equals("") || userph.equals("")) {
					Toast.makeText(Registration.this,
							"Please Enter All Required Field  ",
							Toast.LENGTH_SHORT).show();
					uname.setText("");
					pwd.setText("");
					cpwd.setText("");
					dob.setText("");

					ph.setText("");

				} else if (!userpwd.equals(usercpwd)) {

					Toast.makeText(Registration.this, "Password not Match",
							Toast.LENGTH_SHORT).show();
					pwd.setText("");
					cpwd.setText("");
					// pwd.addFocusables(null,1);
				} else if (!checkEmail(usereid)) {

					Toast.makeText(Registration.this, "Invalid Email Addresss",
							Toast.LENGTH_SHORT).show();
					eid.setText("");
				}

				else if (numberValidation(userph)) {
					Toast.makeText(Registration.this, "Invalid Mobile Number",
							Toast.LENGTH_SHORT).show();
					ph.setText("");

				}

				else if (cursor.getCount() == 0) {
					donoradapter.create(usertype, username, usercity, userzip,
							userdob, userph, usereid, userbloodgrp, userbgsign);
					
					
					
					userlogin.createuser(usertype, username, userpwd, userdob, usereid);

					userlogin.close();
					donoradapter.close();
					
					// utype.setText("");
					uname.setText("");
					pwd.setText("");
					cpwd.setText("");
					dob.setText("");
					eid.setText("");
					ph.setText("");

					zip.setText("");
					Toast.makeText(Registration.this, "Registration Successfully Done",
							Toast.LENGTH_SHORT).show();
				}

				else {
					Toast.makeText(Registration.this, "Value Already Exist",
							Toast.LENGTH_SHORT).show();
					uname.setText("");

				}
			}
		});

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v24) {
				// all value set to null
				uname.setText("");
				pwd.setText("");
				cpwd.setText("");
				dob.setText("");
				ph.setText("");
				eid.setText("");

				zip.setText("");

			}
		});

	}

	private void updateDate() {

		dob.setText(new StringBuilder().append(day).append('-')
				.append(month + 1).append('-').append(year));

	}

	private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int yr, int monthOfYear,
				int dayOfMonth) {

			year = yr;
			month = monthOfYear;
			day = dayOfMonth;
			updateDate();
		}
	};

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, dateListener, year, month, day);

		}
		return null;

	}

	private boolean checkEmail(String email) {
		return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
	}

	public boolean numberValidation(String numberstring) {
		Pattern numberPattern = Pattern.compile("0-9]*");
		Matcher numberMatcher = numberPattern.matcher(numberstring);
		return numberMatcher.matches();
	}

}
