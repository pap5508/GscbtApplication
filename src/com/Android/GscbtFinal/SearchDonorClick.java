package com.Android.GscbtFinal;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_Donor_ptreg_Adapter;

public class SearchDonorClick extends Activity {
	private Button home, back;
	private Cursor cursor;
	private ListView mylist1;
	private Json_Donor_ptreg_Adapter la;
	String id, bg1, bgsign1;
	private SimpleCursorAdapter cursorAdapter;
	List<FormofData2> taskname1;
	MyArrayAdapter arrayadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.donorclickdisplay);

		home = (Button) findViewById(R.id.bbdonorsrc_home);
		back = (Button) findViewById(R.id.bbdonorsrc_back);
		mylist1 = (ListView) findViewById(R.id.bbdonorsrc_lv);

		bg1 = getIntent().getStringExtra("bg");
		bgsign1 = getIntent().getStringExtra("bgsign");

		taskname1 = new ArrayList<FormofData2>();
		la = new Json_Donor_ptreg_Adapter(getApplicationContext());

		try {
			la.open();
			// la.queueAll();
			cursor = la.queueAll_SortBy_CONTENT3(bg1);

			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
			}
			do {
				taskname1.add(new FormofData2(cursor.getString(2), cursor
						.getString(3), cursor.getString(7),
						cursor.getString(0), cursor.getString(8), cursor
								.getString(9)));

			} while (cursor.moveToNext());

		} catch (Exception e) {

			Toast.makeText(getApplicationContext(), "Not any data are stored.",
					Toast.LENGTH_SHORT).show();
			cursor.close();
		}

		arrayadapter = new MyArrayAdapter(getApplicationContext(),
				R.layout.donorlistsearch, taskname1);
		mylist1.setAdapter(arrayadapter);
		arrayadapter.setNotifyOnChange(true);
		arrayadapter.notifyDataSetChanged();
		la.close();
	}

	class MyArrayAdapter extends ArrayAdapter<FormofData2> {

		public MyArrayAdapter(Context context, int resource,
				List<FormofData2> objects) {
			super(context, resource, objects);
		}

		class ViewHolder {

			protected TextView aa;
			protected TextView bb;
			protected TextView cc;

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.ArrayAdapter#getView(int, android.view.View,
		 * android.view.ViewGroup)
		 */

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			View view = null;

			if (convertView == null) {

				LayoutInflater layoutInflater = getLayoutInflater();
				view = layoutInflater.inflate(R.layout.donorlistsearch, null);

				final ViewHolder viewHolder = new ViewHolder();

				viewHolder.aa = (TextView) view.findViewById(R.id.text1);
				viewHolder.bb = (TextView) view.findViewById(R.id.text2);
				viewHolder.cc = (TextView) view.findViewById(R.id.text3);

				/*
				 * (non-Javadoc)
				 * 
				 * @see android.widget.CompoundButton.OnCheckedChangeListener
				 * #onCheckedChanged(android.widget.CompoundButton, boolean)
				 */
				view.setTag(viewHolder);
			} else {
				view = convertView;

			}

			ViewHolder holder = (ViewHolder) view.getTag();
			holder.aa.setText(taskname1.get(position).getDonorname());
			holder.bb.setText(taskname1.get(position).getDistrict());
			holder.cc.setText(taskname1.get(position).getEmail());

			// holder.checkbox.setChecked(taskname1.get(position).isSelected());

			return view;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */

	@Override
	protected void onResume() {
		super.onResume();

		arrayadapter.setNotifyOnChange(true);
		arrayadapter.notifyDataSetChanged();
		mylist1.setAdapter(arrayadapter);

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View e1) {
				finish();

			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View e1) {
				finish();
			}
		});

	}
}
