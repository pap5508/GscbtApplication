package com.Android.GscbtFinal;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.Android.GscbtDatabase.Json_BBEvent;

public class EventClick extends Activity {
	private TextView Eventtitle, Approve, Startdate, Enddate, Detail;
	private Button home, back;
	List<FormofData> taskname;
	private String str, str1, str2, str3, str4;
	private Json_BBEvent la;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.listeventclickdisplay);
		Eventtitle = (TextView) findViewById(R.id.text_1);
		Approve = (TextView) findViewById(R.id.text_2);
		Startdate = (TextView) findViewById(R.id.text_3);
		Enddate = (TextView) findViewById(R.id.text_4);
		Detail = (TextView) findViewById(R.id.text_5);

		home = (Button) findViewById(R.id.eventclick_home);
		back = (Button) findViewById(R.id.eventclick_back);
		la = new Json_BBEvent(getApplicationContext());

		str = getIntent().getExtras().getString("eventtitle");
		System.out.println(str);
		Eventtitle.setText(str);

		str1 = getIntent().getExtras().getString("approve");
		System.out.println(str1);
		Approve.setText(str1);

		str2 = getIntent().getExtras().getString("startdate");
		System.out.println(str2);
		Startdate.setText(str2);

		str3 = getIntent().getExtras().getString("enddate");
		System.out.println(str3);
		Enddate.setText(str3);

		str4 = getIntent().getExtras().getString("detail1");
		System.out.println(str4);
		Detail.setText(str4);

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						DonorDetail.class);
				startActivity(intent);

			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});
	}

}
