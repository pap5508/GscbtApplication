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
import android.widget.TextView;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_BBEvent;

public class Event extends Activity {

	private Button home, back;
	private Cursor cursor;
	private ListView mylist;
	private Json_BBEvent la;
	String id1, id, s, o, eventtitle, approve, startdate, enddate, detail1;
	List<FormofData> taskname;
	MyArrayAdapter arrayadapter1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.event);

		home = (Button) findViewById(R.id.event_home);
		back = (Button) findViewById(R.id.event_back);
		mylist = (ListView) findViewById(R.id.eventlist);

		taskname = new ArrayList<FormofData>();
		la = new Json_BBEvent(getApplicationContext());
		System.out.println("sdfdfgf");
		try {
			la.open();
			System.out.println("inside try");
			cursor = la.queueAll();

			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
			}
			do {
				taskname.add(new FormofData(cursor.getString(0), cursor
						.getString(3), cursor.getString(2),
						cursor.getString(5), cursor.getString(6), cursor
								.getString(4)));

			} while (cursor.moveToNext());

			cursor.close();

		} catch (Exception e) {

			Toast.makeText(getApplicationContext(), "Not any data are stored.",
					Toast.LENGTH_SHORT).show();
		}

		arrayadapter1 = new MyArrayAdapter(getApplicationContext(),
				R.layout.listevent, taskname);
		mylist.setAdapter(arrayadapter1);
		arrayadapter1.setNotifyOnChange(true);
		arrayadapter1.notifyDataSetChanged();
		la.close();
	}

	class MyArrayAdapter extends ArrayAdapter<FormofData> {

		public MyArrayAdapter(Context context, int resource,
				List<FormofData> objects) {
			super(context, resource, objects);
		}

		class ViewHolder {

			protected TextView aa;
			// protected TextView bb;
			// protected TextView cc;
			// protected TextView dd;
			protected ImageButton detail;
			protected ImageButton map;

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
				view = layoutInflater.inflate(R.layout.listevent, null);

				final ViewHolder viewHolder = new ViewHolder();

				viewHolder.aa = (TextView) view.findViewById(R.id.text1);
				// viewHolder.bb = (TextView) view.findViewById(R.id.text2);
				// viewHolder.cc = (TextView) view.findViewById(R.id.text3);
				// viewHolder.dd = (TextView) view.findViewById(R.id.text4);
				viewHolder.map = (ImageButton) view
						.findViewById(R.id.event_map);

				// viewHolder.map.setBackgroundColor(color.transparent);
				viewHolder.map.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View mp) {

						id1 = taskname.get(position).getId().toString();
						System.out.println(id1);
						// s = taskname.get(position).getLat().toString();
						// o = taskname.get(position).getLon().toString();

						try {
							Intent pass1 = new Intent(getApplicationContext(),
									CurrentLocation.class);
							/*
							 * pass1.putExtra(s, true); pass1.putExtra(o, true);
							 */
							// pass1.putExtra("id", id1);

							// System.out.println(s);
							// System.out.println(o);

							// pass1.putExtra("lat", s);
							// pass1.putExtra("lng", o);
							startActivity(pass1);
							System.out
									.println("you are pass the intenttttt.........");

						} catch (Exception e) {

							Toast.makeText(getApplicationContext(),
									"not value", Toast.LENGTH_SHORT).show();
						}

					}
				});
				view.setTag(viewHolder);
				viewHolder.map.setTag(taskname.get(position));

				viewHolder.detail = (ImageButton) view
						.findViewById(R.id.event_detail);
				// viewHolder.detail.setBackgroundColor(color.transparent);
				viewHolder.detail
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View arg0) {

								id = taskname.get(position).getId().toString();
								eventtitle = taskname.get(position)
										.getEventtitle().toString();
								approve = taskname.get(position).getApprove()
										.toString();
								startdate = taskname.get(position)
										.getStartdate().toString();
								enddate = taskname.get(position).getEnddate()
										.toString();
								detail1 = taskname.get(position)
										.getDescription().toString();

								System.out.println(id);

								try {
									Intent pass = new Intent(
											getApplicationContext(),
											EventClick.class);
									pass.putExtra("eventtitle", eventtitle);
									pass.putExtra("approve", approve);
									pass.putExtra("startdate", startdate);
									pass.putExtra("enddate", enddate);
									pass.putExtra("detail1", detail1);
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
				viewHolder.detail.setTag(taskname.get(position));

			} else {
				view = convertView;
				((ViewHolder) view.getTag()).detail.setTag(taskname
						.get(position));
				view = convertView;
				((ViewHolder) view.getTag()).map.setTag(taskname.get(position));

			}

			ViewHolder holder = (ViewHolder) view.getTag();
			holder.aa.setText(taskname.get(position).getEventtitle());
			// holder.bb.setText(taskname.get(position).getApprove());
			// holder.cc.setText(taskname.get(position).getStartdate());
			// holder.dd.setText(taskname.get(position).getEnddate());
			// holder.detail.setChecked(taskname.get(position).isSelected());

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

		arrayadapter1.setNotifyOnChange(true);
		arrayadapter1.notifyDataSetChanged();
		mylist.setAdapter(arrayadapter1);

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
