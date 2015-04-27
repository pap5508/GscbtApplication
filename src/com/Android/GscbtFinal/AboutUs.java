package com.Android.GscbtFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AboutUs extends Activity {
	private TextView tv;
	private Button home, back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus);

		home = (Button) findViewById(R.id.about_home);
		back = (Button) findViewById(R.id.about_back);
		tv = (TextView) findViewById(R.id.abt_tv);
		/*
		
		--------------------------THIS CLASS SHOWS THE ABOUT US--------------------------
		
		*/
		
		tv.setText("In accordance with the judgment delivered by the Hon’able Supreme Court of India (vide its judgment delivered in writ petition No. 91/1992) "
				+ "wherein directives were issued of the Central and State government to take stages for ensuring safe blood safety, the government of Gujarat"+ "established the Gujarat State Council for Blood Transfusion (GSCBT)."
				+ "\n \n"
				+ "The GSCBT is registered as a society under the Registration of societies Act, 1860 (Registration No. GUJ/6003/Ahmedabad, dated 12th March,"+ "1997) and also as a Public Trust under the Bombay Public Trust Act 1850 (Registration No. F/5852/Ahmedabad dated 12.03.97)"
				+ "\n \n"
				
				+ "1.Additional Chief Secretary, H & FW, GoG" +"\n"+"   Commissioner"
				+ "\n"
				+ "2.Health Secretary (Expenditure), Finance" +"\n"+"   Dept."
				+ "\n"
				+ "3.Commissioner, Food & Drug Control   " +"\n"+"   Administration"
				+ "\n"
				+ "4.Additional Director, State AIDS Cell"
				+ "\n"
				+ "5.Medical Superintendent, Civil Hospital,   " +"\n"+"   Ahmedabad"
				+ "\n"
				+ "6.Professor & Head, Department of Pathology,"+"\n"+"   BJMC, Ahmedabad"
				+ "\n"
				+ "7.Executive Officer, IRCS, Gujarat State branch," +"\n"+"   Ahmedabad"
				+ "\n"
				+ "8.Representative, State Committee of Indian   " +"\n"+"   Association of Blood Banks, Ahmedabad"+ "  " +"\n"+"   The Supreme Court has directed the Central" +"\n"+"   government to exempt from Income Tax   " +"\n"+"   payment all donations received (for the   " +"\n"+"   purpose of ensuring"+ "safe blood supply) by" +"\n"+"   the Council for Blood Transfusion."
				+ "\n \n"
				+ "    The Central government has granted 100%" +"\n"+"   exemption from the Income Tax (by   " +"\n"+"   modifying the I.T. Tax, 1961) for donation of" +"\n"+"   the Nation/State"+ "Blood Councils.");

		home.setOnClickListener(new OnClickListener() {

			/*
			 
			------HOME BUTTON IS CALLED AND BACK TO THE MAIN VIEW OF APPLICATION------
			 
			 */
			
			@Override
			public void onClick(View arg0) {
				Intent mainv = new Intent(getApplicationContext(),
						GSCBTFINALActivity.class);
				startActivity(mainv);

			}
		});
		back.setOnClickListener(new OnClickListener() {

			/*
			 
			------HOME BUTTON IS CALLED AND BACK TO THE MAIN VIEW OF APPLICATION------
			 
			 */
			
			@Override
			public void onClick(View arg0) {
				Intent mainv1 = new Intent(getApplicationContext(),
						GSCBTFINALActivity.class);
				startActivity(mainv1);

			}
		});
	}

}
