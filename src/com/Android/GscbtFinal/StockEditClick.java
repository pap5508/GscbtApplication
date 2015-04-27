package com.Android.GscbtFinal;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_BBAdapter;
import com.Android.GscbtDatabase.Json_BBStock;
import com.Android.GscbtDatabase.ListAdapter1;

public class StockEditClick extends Activity {

	private Json_BBStock la;
	private Cursor cursor;
	private String str, str1, str2, str3,str4;
	private EditText UId, Name, Group, Stock;
	private Button home, back, update;

	List<FormofData1> taskname1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.stockeditclickdisplay);

		home = (Button) findViewById(R.id.stockclick_home);
		back = (Button) findViewById(R.id.stockclick_back);
		update = (Button) findViewById(R.id.stockclick_update);
		UId = (EditText) findViewById(R.id.text_1);
		Name = (EditText) findViewById(R.id.text_2);
		Group = (EditText) findViewById(R.id.text_3);
		Stock = (EditText) findViewById(R.id.text_4);
		la = new Json_BBStock(getApplicationContext());

		str4 = getIntent().getExtras().getString("id");
		System.out.println(str4);
	

		str = getIntent().getExtras().getString("uid");
		System.out.println(str);
		UId.setText(str);

		str1 = getIntent().getExtras().getString("name");
		System.out.println(str1);
		Name.setText(str1);

		str2 = getIntent().getExtras().getString("group");
		System.out.println(str2);
		Group.setText(str2);

		str3 = getIntent().getExtras().getString("stock");
		System.out.println(str3);
		Stock.setText(str3);
		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View e1) {
				Intent eventclicklist = new Intent(getApplicationContext(),
						BloodBankDetail.class);
				startActivity(eventclicklist);
			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View e1) {
				finish();

			}
		});

		update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				la.open();
				la.queueAll();

				str1 = Name.getText().toString();
				str2 = Group.getText().toString();

				str3 = Stock.getText().toString();

				la.updatedata(str4,str1, str2, str3);
				Name.setText("");
				Group.setText("");
				Stock.setText("");

				la.close();

				Toast.makeText(getApplicationContext(), "Successfully Updated",
						Toast.LENGTH_LONG).show();

			}
		});
	}

}
