package com.Android.GscbtFinal;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Android.GscbtDatabase.Json_Adapter_user;
import com.Android.GscbtDatabase.Json_BBAdapter;
import com.Android.GscbtDatabase.Json_BBEvent;
import com.Android.GscbtDatabase.Json_BBStock;
import com.Android.GscbtDatabase.Json_Donor_ptreg_Adapter;

public class GSCBTFINALActivity extends Activity {
	private TextView gscbt, abtgscbt;
	Json_Adapter_user ap;
	Json_BBAdapter ap1;
	Json_Donor_ptreg_Adapter ap2;
	Json_BBStock ap3;
	Json_BBEvent ap4;

	private static final int OK_MENU_ITEM = Menu.FIRST;
	private Button user, search, aboutus, contactus, exit;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//gscbt = (TextView) findViewById(R.id.tv_gscbt);
		ap = new Json_Adapter_user(getApplicationContext());
		ap1 = new Json_BBAdapter(getApplicationContext());
		ap2 = new Json_Donor_ptreg_Adapter(getApplicationContext());
		ap3 = new Json_BBStock(getApplicationContext());
		ap4 = new Json_BBEvent(getApplicationContext());

		ap.open();
		ap1.open();
		ap2.open();
		ap3.open();
		ap4.open();
		/*
		 * try {
		 * 
		 * ap.deleteAll(); ap1.deleteAll(); ap2.deleteAll(); ap3.deleteAll();
		 * ap4.deleteAll();
		 * 
		 * } catch (Exception e) { System.out.println(e);
		 * System.out.println("ecxeption occur"); }
		 */

		search = (Button) findViewById(R.id.main_search);
		user = (Button) findViewById(R.id.main_user);
		aboutus = (Button) findViewById(R.id.main_aboutus);
		contactus = (Button) findViewById(R.id.main_contactus);
		exit = (Button) findViewById(R.id.main_exit);

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v1) {
				// go to donor view
				Intent i1 = new Intent(getApplicationContext(), Search.class);
				startActivity(i1);
			}
		});

		user.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v2) {
				// go to patient view

				Intent i2 = new Intent(getApplicationContext(), User.class);
				startActivity(i2);
			}
		});
		aboutus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v3) {
				// go to bloodbank view
				Intent i3 = new Intent(getApplicationContext(), AboutUs.class);
				startActivity(i3);

			}
		});
		contactus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v4) {
				// go to contact view
				Intent i4 = new Intent(getApplicationContext(), ContactUs.class);
				startActivity(i4);

			}
		});
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v5) {
				// close the application
				System.exit(0);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// create menu item for update the data
		menu.add(0, OK_MENU_ITEM, 0, "Update");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// on menu selected toast that menu is selected
		Toast.makeText(getApplicationContext(), "menu selected",
				Toast.LENGTH_LONG).show();

		// this is for user login...........
		try {
			InputStream is = this.getResources().openRawResource(
					R.raw.userlogin);
			byte[] buffer = new byte[is.available()];
			while (is.read(buffer) != -1)
				;
			String jsontext = new String(buffer);
			JSONArray entries = new JSONArray(jsontext);

			System.out.println("Before entering the first loopppp");
			for (int i = 0; i < entries.length(); i++) {
				JSONObject post = entries.getJSONObject(i);

				String id1 = post.getString("UserID").toString();
				String utype1 = post.getString("UserType").toString();
				String uname1 = post.getString("UserName").toString();

				String pwd1 = post.getString("Password").toString();
				String dob1 = post.getString("DOB").toString();
				String email1 = post.getString("MailID").toString();

				/*
				 * System.out.println(id1); System.out.println(utype1);
				 * System.out.println(uname1); System.out.println(pwd1);
				 * System.out.println(dob1); System.out.println(email1);
				 */
				// ap.open();

				ap.createuser(id1, utype1, uname1, pwd1, dob1, email1);

			}
			ap.close();
			System.out.println("after complete the first loop");
		}

		catch (Exception e) {

		}

		// this is for blood bank registration
		try {
			InputStream is1 = this.getResources().openRawResource(
					R.raw.bloodbank_reg);
			byte[] buffer1 = new byte[is1.available()];
			while (is1.read(buffer1) != -1)
				;
			String jsontext1 = new String(buffer1);
			JSONArray entries1 = new JSONArray(jsontext1);

			System.out.println("Before entering the bb loopppp");
			for (int j = 0; j < entries1.length(); j++) {
				JSONObject post1 = entries1.getJSONObject(j);

				String bbid1 = post1.getString("UserID").toString();
				String bbname1 = post1.getString("BloodBankName").toString();
				String bbadd1 = post1.getString("Address").toString();

				String bbtown1 = post1.getString("Town").toString();
				String bbdist1 = post1.getString("District").toString();
				String bbpin1 = post1.getString("Pincode").toString();

				String phno1 = post1.getString("ContactPersonNo").toString();
				String email1 = post1.getString("EMail").toString();
				String website1 = post1.getString("WebSite").toString();

				String license1 = post1.getString("LicenseNo").toString();
				String cat1 = post1.getString("CategoryOfBloodBank").toString();
				String subcat1 = post1.getString("SubCategory").toString();
				String app1 = post1.getString("Approved").toString();

				/*
				 * System.out.println(bbid1); System.out.println(bbname1);
				 * System.out.println(bbadd1); System.out.println(bbtown1);
				 * System.out.println(bbdist1); System.out.println(bbpin1);
				 * System.out.println(phno1); System.out.println(email1);
				 * System.out.println(website1); System.out.println(license1);
				 * System.out.println(cat1); System.out.println(subcat1);
				 * System.out.println(app1);
				 */
				// ap1.open();

				ap1.create(bbid1, bbname1, bbadd1, bbtown1, bbdist1, bbpin1,
						phno1, email1, website1, license1, cat1, subcat1, app1);

			}
			ap1.close();
			System.out.println("after complete the second loop");
		}

		catch (Exception e) {
			System.out.println(e);
		}

		// this is for donor patient registration

		try {
			InputStream is2 = this.getResources().openRawResource(
					R.raw.donor_patient_reg);
			byte[] buffer1 = new byte[is2.available()];
			while (is2.read(buffer1) != -1)
				;
			String jsontext2 = new String(buffer1);
			JSONArray entries2 = new JSONArray(jsontext2);

			System.out.println("Before entering the dpreg loopppp");
			for (int k = 0; k < entries2.length(); k++) {
				JSONObject post2 = entries2.getJSONObject(k);

				String uid = post2.getString("UserId").toString();
				String typeuser = post2.getString("TypeOfUser").toString();
				String dname = post2.getString("DonorName").toString();
				String dist = post2.getString("District").toString();
				String pin = post2.getString("Pincode").toString();
				String ddob = post2.getString("DOB").toString();
				String mono = post2.getString("MobileNo").toString();
				String eid = post2.getString("EmailId").toString();
				String bg = post2.getString("BloodGroup").toString();
				String bgrh = post2.getString("BloodGroupRH").toString();

				/*
				 * System.out.println(uid); System.out.println(typeuser);
				 * System.out.println(dname); System.out.println(dist);
				 * System.out.println(pin); System.out.println(ddob);
				 * System.out.println(mono); System.out.println(eid);
				 * System.out.println(bg); System.out.println(bgrh);
				 */
				// ap2.open();

				ap2.create(typeuser, dname, dist, pin, ddob, mono, eid, bg,
						bgrh);

			}
			ap2.close();
			System.out.println("after complete the third loop");
		}

		catch (Exception e) {
			System.out.println(e);
		}

		// ........this is for blood bank stock.......

		try {
			InputStream is3 = this.getResources().openRawResource(
					R.raw.bloodbank_stock);
			byte[] buffer3 = new byte[is3.available()];
			while (is3.read(buffer3) != -1)
				;
			String jsontext3 = new String(buffer3);
			JSONArray entries3 = new JSONArray(jsontext3);

			System.out.println("Before entering the bb stock loopppp");
			for (int l = 0; l < entries3.length(); l++) {
				JSONObject post3 = entries3.getJSONObject(l);

				String uid3 = post3.getString("UserId").toString();
				String bg3 = post3.getString("BloodGroup").toString();
				String wblood = post3.getString("WholeBlood").toString();
				String packcell = post3.getString("PackedCells").toString();
				String plt = post3.getString("PlateletConcentrate").toString();
				String frs = post3.getString("FreshFrozenPlasma").toString();
				String sh = post3.getString("Stock").toString();

				/*
				 * System.out.println(uid3); System.out.println(bg3);
				 * System.out.println(wblood); System.out.println(packcell);
				 * System.out.println(plt); System.out.println(frs);
				 * System.out.println(sh);
				 */
				// ap3.open();

				ap3.create(uid3, bg3, wblood, packcell, plt, frs, sh);

			}
			ap3.close();
			System.out.println("after complete the third loop");
		}

		catch (Exception e) {
			System.out.println(e);
		}

		// this is for event_trans...

		try {
			InputStream is5 = this.getResources().openRawResource(
					R.raw.event_trans);
			byte[] buffer5 = new byte[is5.available()];
			while (is5.read(buffer5) != -1)
				;
			String jsontext5 = new String(buffer5);
			JSONArray entries5 = new JSONArray(jsontext5);

			System.out.println("Before entering the event loopppp");
			for (int n = 0; n < entries5.length(); n++) {
				JSONObject post5 = entries5.getJSONObject(n);

				String uid5 = post5.getString("UserId").toString();
				String app5 = post5.getString("Approved").toString();
				String et5 = post5.getString("EventTitle").toString();
				String evtdesc5 = post5.getString("EventDesc").toString();
				String sdate = post5.getString("StartingDate").toString();
				String edate = post5.getString("EndingDate").toString();

				/*
				 * System.out.println(uid5); System.out.println(app5);
				 * System.out.println(et5); System.out.println(evtdesc5);
				 * System.out.println(sdate); System.out.println(edate);
				 */
				// ap4.open();

				ap4.create(uid5, app5, et5, evtdesc5, sdate, edate);

			}
			ap4.close();
			Toast.makeText(getApplicationContext(), "Sync Successfully..", 1)
					.show();
			System.out.println("after complete the fourth loop");
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return super.onOptionsItemSelected(item);
	}

}