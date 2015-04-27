package com.Android.GscbtFinal;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
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
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_Adapter_user;
import com.Android.GscbtDatabase.Json_BBAdapter;

public class BBRegistration extends Activity {

	private EditText bbtype, bbname, bbuname, bbpwd, bbcpwd, bblicno, bbadd,
			bbtown, bbpin, bbph, bbeid, bbsite;
	private String BBuid, BButype, BBname, BBuname, BBpwd, BBcpwd, BBlicno,
			BBadd, BBtown, BBpin, BBph, BBeid, BBsite, BBcat, BBsubcat, BBDist,
			BBnaco, dr;
	private Button bbhome, bbsub, bbcancel;
	private Spinner bbcat, bbsubcat, bbdist, bbnaco;
	Cursor BBcursor;
	List<FormofData3> taskname;
	private ArrayAdapter cityadp, category, subcategory, naco;
	Json_BBAdapter bbadapter;
	Json_Adapter_user bbuser;
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// .....THIS IS XML LAYOUT FILE.....
		setContentView(R.layout.bbregistration);

		// .....ALL THE VARIABLES DECLARE OBJECT HERE.....

		bbtype = (EditText) findViewById(R.id.reg_utypebb);
		bbname = (EditText) findViewById(R.id.reg_namebb);
		bbuname = (EditText) findViewById(R.id.reg_unamebb);
		bbpwd = (EditText) findViewById(R.id.reg_pwdbb);
		bbcpwd = (EditText) findViewById(R.id.reg_cpwdbb);
		bblicno = (EditText) findViewById(R.id.reg_licnobb);
		bbadd = (EditText) findViewById(R.id.reg_addbb);
		bbtown = (EditText) findViewById(R.id.reg_statebb);
		bbpin = (EditText) findViewById(R.id.reg_zipbb);
		bbph = (EditText) findViewById(R.id.reg_phbb);
		bbeid = (EditText) findViewById(R.id.reg_eidbb);
		bbsite = (EditText) findViewById(R.id.reg_sitebb);

		bbhome = (Button) findViewById(R.id.reg_homebb);
		bbsub = (Button) findViewById(R.id.reg_submitbb);
		bbcancel = (Button) findViewById(R.id.reg_cancelbb);
		bbcat = (Spinner) findViewById(R.id.reg_spinnercatbb);
		bbsubcat = (Spinner) findViewById(R.id.reg_spinnersubcatbb);
		bbdist = (Spinner) findViewById(R.id.reg_spinnercitybb);
		bbnaco = (Spinner) findViewById(R.id.reg_spinnernacobb);

		// .....THIS TWO ARE ADAPTER OBJECTS.....

		bbadapter = new Json_BBAdapter(getApplicationContext());
		bbuser = new Json_Adapter_user(getApplicationContext());

		// .....SELECT ONE OF THEM IN CATEGORY EITHER YES OR NO.....

		category = ArrayAdapter.createFromResource(this, R.array.Category,
				android.R.layout.simple_spinner_item);
		category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbcat.setAdapter(category);
		bbcat.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				BBcat = bbcat.getItemAtPosition(position).toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		// .....SELECT THE BLOODBANK IS NACO APPROVED OR NOT.....

		naco = ArrayAdapter.createFromResource(this, R.array.Naco,
				android.R.layout.simple_spinner_item);
		naco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbnaco.setAdapter(naco);
		bbnaco.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				BBnaco = bbnaco.getItemAtPosition(position).toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		// .....SELECT THE BLOODBANK SUB CATEGORY.....

		subcategory = ArrayAdapter.createFromResource(this, R.array.Category,
				android.R.layout.simple_spinner_item);
		subcategory
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbsubcat.setAdapter(subcategory);
		bbsubcat.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				BBsubcat = bbsubcat.getItemAtPosition(position).toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		// .....SELECT WHERE THE BLOOD BANK IS SITUATED.....

		cityadp = ArrayAdapter.createFromResource(this, R.array.City,
				android.R.layout.simple_spinner_item);
		cityadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bbdist.setAdapter(cityadp);
		bbdist.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				BBDist = bbdist.getItemAtPosition(pos).toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		bbhome.setOnClickListener(new OnClickListener() {

			public void onClick(View v22) {
				// GOTO MAIN VIEW OF BLOOD BANK
				finish();
			}
		});

		bbsub.setOnClickListener(new OnClickListener() {

			public void onClick(View v23) {

				// .....GET ALL THE VALUE FIELD IN STRING.....

				BButype = bbtype.getText().toString();
				BBname = bbname.getText().toString();
				BBuname = bbuname.getText().toString();
				BBpwd = bbpwd.getText().toString();
				BBcpwd = bbcpwd.getText().toString();
				BBlicno = bblicno.getText().toString();
				BBadd = bbadd.getText().toString();
				BBtown = bbtown.getText().toString();
				BBpin = bbpin.getText().toString();
				BBph = bbph.getText().toString();
				BBeid = bbeid.getText().toString();
				BBsite = bbsite.getText().toString();

				/*
				 * ..... OPEN THE BLOOD BANK ADAPTER FOR INSERT VERIFY..ALL THE
				 * DETAILS.....
				 */
				bbadapter.open();
				bbuser.open();

				BBcursor = bbuser.verifyUser(BBuname);

				if (BBname.equals("") || BBuname.equals("") || BBpwd.equals("")
						|| BBcpwd.equals("") || BBcat.equals("")
						|| BBsubcat.equals("") || BBlicno.equals("")
						|| BBnaco.equals("") || BBadd.equals("")
						|| BBph.equals("")) {
					Toast.makeText(BBRegistration.this,
							"please enter all required field  ",
							Toast.LENGTH_SHORT).show();
					bbname.setText("");
					bbuname.setText("");
					bbpwd.setText("");
					bbcpwd.setText("");
					bblicno.setText("");
					bbadd.setText("");
					bbph.setText("");

				} else if (!BBpwd.equals(BBcpwd)) {

					Toast.makeText(BBRegistration.this, "Password not Match",
							Toast.LENGTH_SHORT).show();
					bbpwd.setText("");
					bbcpwd.setText("");

				} else if (!checkEmail(BBeid)) {

					Toast.makeText(BBRegistration.this,
							"Invalid Email Addresss", Toast.LENGTH_SHORT)
							.show();
					bbeid.setText("");
				} else if (numberValidation(BBph)) {
					Toast.makeText(BBRegistration.this,
							"Invalid Mobile Number", Toast.LENGTH_SHORT).show();
					bbph.setText("");

				}

				else if (BBcursor.getCount() == 0) {

					bbuser.create(BBuid, BButype, BBuname, BBpwd, BBeid);
					/*
					 * BBcursor = bbuser.queueAll();
					 * 
					 * while (BBcursor.moveToLast()) {
					 * 
					 * System.out.println("inside do whileee loop...");
					 * taskname.add(new FormofData3(BBcursor.getString(1)));
					 * BBuid = taskname.get(1).getUserid().toString();
					 * System.out.println(BBuid);
					 * 
					 * }
					 */

					/*
					 * if (cursor.isLast()) { dr =
					 * cursor.getString(1).toString(); bbadapter.create(dr,
					 * BBname, BBadd, BBtown, BBDist, BBpin, BBph, BBeid,
					 * BBsite, BBlicno, BBcat, BBsubcat, BBnaco);
					 * 
					 * }
					 */

					bbadapter.create(BBuid, BBname, BBadd, BBtown, BBDist,
							BBpin, BBph, BBeid, BBsite, BBlicno, BBcat,
							BBsubcat, BBnaco);

					bbadapter.close();
					bbuser.close();
					Toast.makeText(getApplicationContext(),
							"Registration Successfully", Toast.LENGTH_SHORT)
							.show();
					bbname.setText("");
					bbuname.setText("");
					bbpwd.setText("");
					bbcpwd.setText("");
					bblicno.setText("");
					bbadd.setText("");
					bbtown.setText("");
					bbpin.setText("");
					bbph.setText("");
					bbeid.setText("");
					bbsite.setText("");

				} else {

					// .....EXCEPTION.....
					Toast.makeText(BBRegistration.this,
							"Username Already Exist", Toast.LENGTH_SHORT)
							.show();

					bbuname.setText("");
					bbname.setText("");

				}

			}
		});

		bbcancel.setOnClickListener(new OnClickListener() {

			public void onClick(View v24) {
				// goto main page
				finish();

			}
		});

	}

	// .....EMAIL VERIFICATION.....

	private boolean checkEmail(String email) {
		return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
	}

	// .....NUMBER VALIDATION.....

	public boolean numberValidation(String numberstring) {
		Pattern numberPattern = Pattern.compile("0-9]*");
		Matcher numberMatcher = numberPattern.matcher(numberstring);
		return numberMatcher.matches();
	}

}
