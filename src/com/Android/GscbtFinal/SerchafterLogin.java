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
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_BBAdapter;
import com.Android.GscbtDatabase.ListAdapter1;

public class SerchafterLogin extends Activity {
	private Button home, back, search, msg;
	String id1, id, s, o, bbname, bg1, stock, add, ph,whlbld,pcktcell,pltcnt,frshfrzn;
	private Json_BBAdapter la;
	private Cursor cursor;
	private SimpleCursorAdapter cursorAdapter;
	private TableLayout tl;
	private String sort, bg;
	List<FormofData3> taskname;
	MyArrayAdapter arrayadapter;
	private ListView mylist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchaftrlgn);
		home = (Button) findViewById(R.id.serchlgn_home);
		back = (Button) findViewById(R.id.serchlgn_back);

		mylist = (ListView) findViewById(R.id.serchlgnlist);

		taskname = new ArrayList<FormofData3>();
		String bg1 = getIntent().getStringExtra("bg");
		String sort1 = getIntent().getStringExtra("sort");
		la = new Json_BBAdapter(getApplicationContext());

		try {
			la.open();
			cursor = la.queueAll();
			cursor = la.queueAll_SortBy_CONTENT_CITY(sort1, bg1);

			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
			}
			do {
				taskname.add(new FormofData3(cursor.getString(1), cursor
						.getString(2), cursor.getString(3),
						cursor.getString(5), cursor.getString(16), cursor
								.getString(17), cursor.getString(18), cursor
								.getString(19), cursor.getString(20), cursor
								.getString(7)));

			} while (cursor.moveToNext());

			cursor.close();

		} catch (Exception e) {

			Toast.makeText(getApplicationContext(), "Not any data are stored.",
					Toast.LENGTH_SHORT).show();
		}

		arrayadapter = new MyArrayAdapter(getApplicationContext(),
				R.layout.listsrhafterlgn, taskname);
		mylist.setAdapter(arrayadapter);
		arrayadapter.setNotifyOnChange(true);
		arrayadapter.notifyDataSetChanged();
		la.close();
	}

	class MyArrayAdapter extends ArrayAdapter<FormofData3> {

		public MyArrayAdapter(Context context, int resource,
				List<FormofData3> objects) {
			super(context, resource, objects);
		}

		class ViewHolder {

			protected TextView aa;
			protected TextView bb;

			protected ImageButton detail;
			protected ImageButton map;
			protected ImageButton msg;

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
				view = layoutInflater.inflate(R.layout.listsrhafterlgn, null);

				final ViewHolder viewHolder = new ViewHolder();

				viewHolder.aa = (TextView) view.findViewById(R.id.text1);
				viewHolder.bb = (TextView) view.findViewById(R.id.text2);

				viewHolder.map = (ImageButton) view
						.findViewById(R.id.search_map);

				// viewHolder.map.setBackgroundColor(color.transparent);
				viewHolder.map.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View mp) {

						id1 = taskname.get(position).getId().toString();
						System.out.println(id1);
						s = taskname.get(position).getLat().toString();
						o = taskname.get(position).getLon().toString();

						try {
							Intent pass1 = new Intent(getApplicationContext(),
									CurrentLocation.class);
							/*
							 * pass1.putExtra(s, true); pass1.putExtra(o, true);
							 */
							// pass1.putExtra("id", id1);

							System.out.println(s);
							System.out.println(o);

							pass1.putExtra("lat", s);
							pass1.putExtra("lng", o);
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
						.findViewById(R.id.search_detail);
				// viewHolder.detail.setBackgroundColor(color.transparent);
				viewHolder.detail
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View arg0) {

								id = taskname.get(position).getId().toString();
								bbname = taskname.get(position).getBbname()
										.toString();
								bg = taskname.get(position).getBg().toString();
								stock = taskname.get(position).getWholeblood()
										.toString();
								add = taskname.get(position).getAddress()
										.toString();
								pcktcell=taskname.get(position).getPackcells()
								.toString();
								pltcnt=taskname.get(position).getPltcont()
								.toString();
								frshfrzn=taskname.get(position).getFrsfrozen()
								.toString();
								
								System.out.println(id);

								try {
									Intent pass = new Intent(
											getApplicationContext(),
											SearchDetailClick.class);
									pass.putExtra("bbname", bbname);
									pass.putExtra("bg", bg);
									pass.putExtra("stock", stock);
									pass.putExtra("add", add);
									pass.putExtra("pcktcell", pcktcell);
									pass.putExtra("pltcnt", pltcnt);
									pass.putExtra("frshfrzn", frshfrzn);

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

				viewHolder.msg = (ImageButton) view
						.findViewById(R.id.search_msg);
				// viewHolder.detail.setBackgroundColor(color.transparent);
				viewHolder.msg.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						ph = taskname.get(position).getPhoneno().toString();
						System.out.println(ph);
						try {
							Intent pass = new Intent(getApplicationContext(),
									Sms.class);

							pass.putExtra("ph", ph);

							startActivity(pass);

						} catch (Exception e) {

							Toast.makeText(getApplicationContext(),
									"not value", Toast.LENGTH_SHORT).show();
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
				viewHolder.msg.setTag(taskname.get(position));

			} else {
				view = convertView;
				((ViewHolder) view.getTag()).detail.setTag(taskname
						.get(position));
				view = convertView;
				((ViewHolder) view.getTag()).map.setTag(taskname.get(position));
				view = convertView;
				((ViewHolder) view.getTag()).msg.setTag(taskname.get(position));

			}

			ViewHolder holder = (ViewHolder) view.getTag();
			holder.bb.setText(taskname.get(position).getWholeblood());
			holder.aa.setText(taskname.get(position).getBbname());

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

		arrayadapter.setNotifyOnChange(true);
		arrayadapter.notifyDataSetChanged();
		mylist.setAdapter(arrayadapter);

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
