package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Android.GscbtDatabase.BloodBankAdapter;
import com.Android.GscbtDatabase.DonorAdapter;
import com.Android.GscbtDatabase.Json_Adapter_user;
import com.Android.GscbtDatabase.Json_Donor_ptreg_Adapter;

public class Login extends Activity {
	private Button home, back, cancel, login;
	private EditText username, password;
	private String uname, pwd, verify, verifybb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		home = (Button) findViewById(R.id.log_home);
		back = (Button) findViewById(R.id.log_back);
		cancel = (Button) findViewById(R.id.log_cancel);
		login = (Button) findViewById(R.id.log_in);
		username = (EditText) findViewById(R.id.log_uname);
		password = (EditText) findViewById(R.id.log_pwd);

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View lo) {
				uname = username.getText().toString();
				pwd = password.getText().toString();

				try {

					verify = getIntent().getExtras().getString("Donor");
					if (uname.length() > 0 && pwd.length() > 0
							&& verify.equals("Donor")) {
						Json_Donor_ptreg_Adapter donoradapter = new Json_Donor_ptreg_Adapter(
								Login.this);
						
						donoradapter.open();
						

						if (donoradapter.Login("Donor", uname, pwd)) {
							Toast.makeText(Login.this,
									"Successfully Logged In", Toast.LENGTH_LONG)
									.show();

							Intent donorlogin = new Intent(
									getApplicationContext(), DonorDetail.class);
							String str = "uname";
							donorlogin.putExtra("uname", uname);
							startActivity(donorlogin);
							donoradapter.close();
							username.setText("");
							password.setText("");

						} else {
							Toast.makeText(Login.this,
									"Invalid Username/Password",
									Toast.LENGTH_LONG).show();

							username.setText("");
							password.setText("");

						}
					}
				} catch (Exception e) {

				}

				try {
					verify = getIntent().getExtras().getString("Donor");
					if (uname.length() > 0 && pwd.length() > 0
							&& verify.equals("Patient")) {
						Json_Donor_ptreg_Adapter donoradapter = new Json_Donor_ptreg_Adapter(
								Login.this);
						
						donoradapter.open();
						if (donoradapter.Login("Patient", uname, pwd)) {
							Toast.makeText(Login.this,
									"Successfully Logged In", Toast.LENGTH_LONG)
									.show();
							Intent patientlogin = new Intent(
									getApplicationContext(),
									PatientDetail.class);
							String str = "uname";
							patientlogin.putExtra("uname", uname);
							startActivity(patientlogin);
							donoradapter.close();
							username.setText("");
							password.setText("");
						} else {
							Toast.makeText(Login.this,
									"Invalid Username/Password",
									Toast.LENGTH_LONG).show();
							username.setText("");
							password.setText("");
						}
					}
				} catch (Exception e) {

				}

				try {
					verifybb = getIntent().getExtras().getString("BloodBank");
					if (uname.length() > 0 && pwd.length() > 0
							&& verifybb.equals("BloodBank")) {
						Json_Adapter_user bbadapter = new Json_Adapter_user(
								Login.this);
						bbadapter.open();

						if (bbadapter.Login(uname, pwd)) {
							Toast.makeText(Login.this,
									"Successfully Logged In", Toast.LENGTH_LONG)
									.show();
							Intent bblogin = new Intent(
									getApplicationContext(),
									BloodBankDetail.class);
							String str = "uname";
							bblogin.putExtra("uname", uname);
							startActivity(bblogin);
							bbadapter.close();
							username.setText("");
							password.setText("");
						} else {
							Toast.makeText(Login.this,
									"Invalid Username/Password",
									Toast.LENGTH_LONG).show();

							username.setText("");
							password.setText("");

						}

					}
				} catch (Exception e) {

				}

			}

		});

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				finish();
			}
		});

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			}
		});
	}

}
