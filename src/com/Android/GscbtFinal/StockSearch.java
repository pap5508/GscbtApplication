package com.Android.GscbtFinal;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_BBStock;

public class StockSearch extends Activity {
	private Button home, back;
	private Cursor cursor;
	private ListView mylist1;
	private Json_BBStock la;
	String id,uid, name, group, stock, bg1, es1;
	private SimpleCursorAdapter cursorAdapter;
	List<FormofData1> taskname1;
	MyArrayAdapter arrayadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.stocksearch);

		home = (Button) findViewById(R.id.stockdetail_home);
		back = (Button) findViewById(R.id.stockdetail_back);
		mylist1 = (ListView) findViewById(R.id.stocklist);

		taskname1 = new ArrayList<FormofData1>();
		la = new Json_BBStock(getApplicationContext());

		bg1 = getIntent().getStringExtra("bg");
		es1 = getIntent().getStringExtra("es");
		System.out.println(es1);

		try {
			la.open();
			la.queueAll();
			cursor = la.queueAll_SortBy_CONTENT_BG1(bg1, es1);

			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
			}
			do {
				taskname1.add(new FormofData1(cursor.getString(0), cursor
						.getString(1), cursor.getString(2),
						cursor.getString(3), cursor.getString(4), cursor
								.getString(5), cursor.getString(6), cursor
								.getString(11)));

			} while (cursor.moveToNext());

		} catch (Exception e) {

			Toast.makeText(getApplicationContext(), "Not any data are stored.",
					Toast.LENGTH_SHORT).show();
			cursor.close();
		}

		arrayadapter = new MyArrayAdapter(getApplicationContext(),
				R.layout.stocklistsearch, taskname1);
		mylist1.setAdapter(arrayadapter);
		arrayadapter.setNotifyOnChange(true);
		arrayadapter.notifyDataSetChanged();
		la.close();
	}

	class MyArrayAdapter extends ArrayAdapter<FormofData1> {

		public MyArrayAdapter(Context context, int resource,
				List<FormofData1> objects) {
			super(context, resource, objects);
		}

		class ViewHolder {

			protected TextView aa;
			protected TextView bb;
			protected TextView cc;
			protected TextView dd;

			protected ImageButton checkbox;
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
				view = layoutInflater.inflate(R.layout.stocklistsearch, null);

				final ViewHolder viewHolder = new ViewHolder();

				viewHolder.aa = (TextView) view.findViewById(R.id.text1);
				viewHolder.bb = (TextView) view.findViewById(R.id.text2);
				viewHolder.cc = (TextView) view.findViewById(R.id.text3);
				viewHolder.dd = (TextView) view.findViewById(R.id.text4);

				viewHolder.checkbox = (ImageButton) view
						.findViewById(R.id.stock_edit);

				viewHolder.checkbox
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View arg0) {
								
								id = taskname1.get(position).getId()
								.toString();
								uid = taskname1.get(position).getUserid()
										.toString();
								name = taskname1.get(position).getWholeblood()
										.toString();
								group = taskname1.get(position).getPackcells()
										.toString();
								stock = taskname1.get(position).getPltcont()
										.toString();

								System.out.println(id);
								System.out.println(uid);
								System.out.println(name);
								System.out.println(group);
								System.out.println(stock);

								try {
									Intent pass = new Intent(
											getApplicationContext(),
											StockEditClick.class);
									pass.putExtra("id", id);
									pass.putExtra("uid", uid);
									pass.putExtra("name", name);
									pass.putExtra("group", group);
									pass.putExtra("stock", stock);

									startActivity(pass);

								} catch (Exception e) {

									Toast.makeText(getApplicationContext(),
											"not value", Toast.LENGTH_SHORT)
											.show();
								}
							}
						});

				/*
				 * (non-Javadoc)
				 * 
				 * @see android.widget.CompoundButton.OnCheckedChangeListener
				 * #onCheckedChanged(android.widget.CompoundButton, boolean)
				 */

				view.setTag(viewHolder);
				viewHolder.checkbox.setTag(taskname1.get(position));

			} else {
				view = convertView;
				((ViewHolder) view.getTag()).checkbox.setTag(taskname1
						.get(position));
			}

			ViewHolder holder = (ViewHolder) view.getTag();
			holder.aa.setText(taskname1.get(position).getUserid());
			holder.bb.setText(taskname1.get(position).getFrsfrozen());
			holder.cc.setText(taskname1.get(position).getPackcells());
			holder.dd.setText(taskname1.get(position).getWholeblood());
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
