package com.Android.GscbtFinal;

import java.util.regex.Matcher;
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

import com.Android.GscbtDatabase.BloodBankAdapter;
import com.Android.GscbtDatabase.Json_Adapter_user;
import com.Android.GscbtDatabase.Json_BBAdapter;

public class BBProfile extends Activity {

	private EditText bbuname, bbpwd, bbcpwd, bbadd, bbstate, bbpin, bbph,
			bbeid;
	private String BBuname, BBpwd, BBcpwd, BBadd, BBstate, BBpin, BBph, BBeid,
			BBcat, BBsubcat, BBcity, BBnaco;
	private Button bbhome, bbupdate, bbcancel, bblogout;
	private Spinner bbcat, bbsubcat, bbcity, bbnaco;
	private Cursor BBcursor;
	private ArrayAdapter cityadp, category, subcategory, naco;
	private TextView ex;
	String es, es1;
	private Json_BBAdapter bbadapter;
	private Json_Adapter_user bbuser;
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bbprofile);
		ex = (TextView) findViewById(R.id.tv_bbpuname);
		es = getIntent().getExtras().getString("uname");
		ex.setText(es);
		bbuname = (EditText) findViewById(R.id.profile_unamebb);
		es1 = getIntent().getExtras().getString("uname");
		bbuname.setText(es1);
		bbpwd = (EditText) findViewById(R.id.profile_pwdbb);
		bbcpwd = (EditText) findViewById(R.id.profile_cpwdbb);

		bbadd = (EditText) findViewById(R.id.profile_addbb);
		bbstate = (EditText) findViewById(R.id.profile_statebb);
		bbpin = (EditText) findViewById(R.id.profile_zipbb);
		bbph = (EditText) findViewById(R.id.profile_phbb);
		bbeid = (EditText) findViewById(R.id.profile_eidbb);

		bbhome = (Button) findViewById(R.id.profile_homebb);
		bbupdate = (Button) findViewById(R.id.profile_submitbb);
		bbcancel = (Button) findViewById(R.id.profile_cancelbb);
		bblogout = (Button) findViewById(R.id.bbprofile_logout);
		bbcat = (Spinner) findViewById(R.id.profile_spinnercatbb);
		bbsubcat = (Spinner) findViewById(R.id.profile_spinnersubcatbb);
		bbcity = (Spinner) findViewById(R.id.profile_spinnercitybb);
		bbnaco = (Spinner) findViewById(R.id.profile_spinnernacobb);

		bbadapter = new Json_BBAdapter(getApplicationContext());
		bbuser = new Json_Adapter_user(getApplicationContext());

		category = ArrayAdapter.createFromResource(this, R.array.Category,
				android.R.layout.simple_spinner_item);
		category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbcat.setAdapter(category);
		bbcat.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				BBcat = bbcat.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		naco = ArrayAdapter.createFromResource(this, R.array.Naco,
				android.R.layout.simple_spinner_item);
		naco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbnaco.setAdapter(naco);
		bbnaco.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				BBnaco = bbnaco.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		subcategory = ArrayAdapter.createFromResource(this, R.array.Category,
				android.R.layout.simple_spinner_item);
		subcategory
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbsubcat.setAdapter(subcategory);
		bbsubcat.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				BBsubcat = bbsubcat.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		cityadp = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		cityadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbcity.setAdapter(cityadp);
		bbcity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				BBcity = bbcity.getItemAtPosition(pos).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		bbhome.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v22) {
				// goto main page
				finish();
			}
		});

		bbupdate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v23) {

				bbadapter.open();
				bbuser.open();
				bbadapter.queueAll();
				BBuname = bbuname.getText().toString();
				BBpwd = bbpwd.getText().toString();
				BBcpwd = bbcpwd.getText().toString();

				BBadd = bbadd.getText().toString();
				BBstate = bbstate.getText().toString();
				BBpin = bbpin.getText().toString();
				BBph = bbph.getText().toString();
				BBeid = bbeid.getText().toString();

				bbadapter.updatedata(BBuname, BBadd, BBph,BBeid, BBcat, BBsubcat,
						BBstate, BBnaco);
				bbuser.updatedata(BBuname,BBpwd,BBeid);

				bbuname.setText("");
				bbpwd.setText("");
				bbcpwd.setText("");
				bbadd.setText("");
				bbstate.setText("");
				bbpin.setText("");
				bbph.setText("");
				bbeid.setText("");
				bbadapter.close();

				Toast.makeText(getApplicationContext(), "Profile Updated Successfully", 1).show();
			}
		});

		bbcancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v24) {
				// set current value null
				bbuname.setText("");
				bbpwd.setText("");
				bbcpwd.setText("");
				bbadd.setText("");
				bbstate.setText("");
				bbpin.setText("");
				bbph.setText("");
				bbeid.setText("");
			}
		});

		bblogout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View rt) {

				Intent logdf = new Intent(getApplicationContext(), Login.class);
				startActivity(logdf);

			}
		});

	}

	public boolean numberValidation(String numberstring) {
		Pattern numberPattern = Pattern.compile("0-9]*");
		Matcher numberMatcher = numberPattern.matcher(numberstring);
		return numberMatcher.matches();
	}

}
