package com.Android.GscbtFinal;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.Android.GscbtDatabase.Json_BBStock;

public class SearchDetailClick extends Activity {

	private TextView Bloodbank, Bloodgrp, Stock, Address, WholeBlood,
			Packedcells, PlateCount, FreshFrozen;
	private Button home, back;
	List<FormofData3> taskname;
	private String str, str1, str2, str3, str4, str5, str6;
	private Json_BBStock la;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchdetailclick);

		Bloodbank = (TextView) findViewById(R.id.text_1);
		Bloodgrp = (TextView) findViewById(R.id.text_2);
		Stock = (TextView) findViewById(R.id.text_3);
		Address = (TextView) findViewById(R.id.text_4);

		Packedcells = (TextView) findViewById(R.id.text_6);
		PlateCount = (TextView) findViewById(R.id.text_7);
		FreshFrozen = (TextView) findViewById(R.id.text_8);

		home = (Button) findViewById(R.id.searchdetail_home);
		back = (Button) findViewById(R.id.searchdetail_back);
		la = new Json_BBStock(getApplicationContext());
		str = getIntent().getExtras().getString("bbname");
		System.out.println(str);
		Bloodbank.setText(str);

		str1 = getIntent().getExtras().getString("bg");
		System.out.println(str1);
		Bloodgrp.setText(str1);

		str2 = getIntent().getExtras().getString("stock");
		System.out.println(str2);
		Stock.setText(str2);

		str3 = getIntent().getExtras().getString("add");
		System.out.println(str3);
		Address.setText(str3);

		str4 = getIntent().getExtras().getString("pcktcell");
		System.out.println(str4);
		Packedcells.setText(str4);

		str5 = getIntent().getExtras().getString("pltcnt");
		System.out.println(str5);
		PlateCount.setText(str5);

		str6 = getIntent().getExtras().getString("frshfrzn");
		System.out.println(str6);
		FreshFrozen.setText(str6);

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
