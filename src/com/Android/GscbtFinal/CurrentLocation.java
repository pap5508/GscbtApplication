package com.Android.GscbtFinal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CurrentLocation extends MapActivity {

	private Button search;
	private String addres, strlat, strlng;
	Double lat, lng, i, j;
	GeoPoint p1, p;
	TextView myLocation;
	MapController mc;
	MapView mapView;
	private EditText ff;
	LocationManager lm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);
		LocationManager locationManager;
		String context = Context.LOCATION_SERVICE;
		locationManager = (LocationManager) getSystemService(context);

		Criteria crta = new Criteria();
		crta.setAccuracy(Criteria.ACCURACY_FINE);
		crta.setAccuracy(Criteria.ACCURACY_COARSE);
		crta.setAltitudeRequired(false);
		crta.setBearingRequired(false);
		crta.setCostAllowed(true);
		crta.setPowerRequirement(Criteria.POWER_LOW);
		String provider = locationManager.getBestProvider(crta, true);
		mapView = (MapView) findViewById(R.id.mapview1);

		search = (Button) findViewById(R.id.button1);
		mapView.setBuiltInZoomControls(true);
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				addres = getIntent().getExtras().getString("s");
				System.out.println(addres);

				getLatitudeAndLongitudeFromGoogleMapForAddress(addres);
				DrawPath(p, p1, Color.RED, mapView);

			}

		});
		// String provider = LocationManager.GPS_PROVIDER;
		Location location = locationManager.getLastKnownLocation(provider);
		updateWithNewLocation(location);

		locationManager.requestLocationUpdates(provider, 1000, 0,
				locationListener);

	}

	public boolean getLatitudeAndLongitudeFromGoogleMapForAddress(String str) {

		Geocoder coder = new Geocoder(this);

		List<Address> address;

		try {

			address = coder.getFromLocationName(str, 5);
			if (address == null) {

				System.out.println("null value");
			}
			Address location = address.get(0);

			System.out.println(location.getLatitude());
			System.out.println(location.getLongitude());

			lat = location.getLatitude();
			lng = location.getLongitude();

			strlat = Double.toString(lat);
			strlng = Double.toString(lng);

			Toast.makeText(getApplicationContext(),
					"Latitude" + strlat + "Longitude" + strlng,
					Toast.LENGTH_SHORT).show();

			p1 = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private final LocationListener locationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			updateWithNewLocation(location);

		}

		@Override
		public void onProviderDisabled(String provider) {
			updateWithNewLocation(null);

		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}

	};

	private void DrawPath(GeoPoint src, GeoPoint dest, int color,
			MapView mMapView01) {

		// connect to map web service
		StringBuilder urlString = new StringBuilder();
		urlString.append("http://maps.google.com/maps?f=d&hl=en");
		urlString.append("&saddr=");
		// source place latitude and longitude
		urlString.append(Double.toString((double) src.getLatitudeE6() / 1.0E6));
		urlString.append(",");
		urlString
				.append(Double.toString((double) src.getLongitudeE6() / 1.0E6));
		urlString.append("&daddr=");
		// destination place latitude and longitude
		urlString
				.append(Double.toString((double) dest.getLatitudeE6() / 1.0E6));
		urlString.append(",");
		urlString
				.append(Double.toString((double) dest.getLongitudeE6() / 1.0E6));
		urlString.append("&ie=UTF8&0&om=0&output=kml");

		Log.d("xxx", "URL=" + urlString.toString());

		/*
		 * get the kml (XML) doc. And parse it to get the coordinates(direction
		 * route).
		 */
		Document doc = null;
		HttpURLConnection urlConnection = null;
		URL url = null;
		try {
			url = new URL(urlString.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.connect();

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(urlConnection.getInputStream());

			if (doc.getElementsByTagName("GeometryCollection").getLength() > 0) {

				// String path =
				// doc.getElementsByTagName("GeometryCollection").item(0).getFirstChild().getFirstChild().getNodeName();
				String path = doc.getElementsByTagName("GeometryCollection")
						.item(0).getFirstChild().getFirstChild()
						.getFirstChild().getNodeValue();

				Log.d("xxx", "path=" + path);

				String[] pairs = path.split(" ");
				String[] lngLat = pairs[0].split(","); // lngLat[0]=longitude
														// lngLat[1]=latitude
														// lngLat[2]=height

				// source geo point for parsing
				GeoPoint startGP = new GeoPoint(
						(int) (Double.parseDouble(lngLat[1]) * 1E6),
						(int) (Double.parseDouble(lngLat[0]) * 1E6));
				mMapView01.getOverlays()
						.add(new MyOverLay(startGP, startGP, 1));

				GeoPoint gp1;
				GeoPoint gp2 = startGP;
				for (int i = 1; i < pairs.length; i++) // the last one would be
														// crash
				{
					lngLat = pairs[i].split(",");
					gp1 = gp2;
					// watch out! For GeoPoint, first:latitude, second:longitude
					gp2 = new GeoPoint(
							(int) (Double.parseDouble(lngLat[1]) * 1E6),
							(int) (Double.parseDouble(lngLat[0]) * 1E6));
					mMapView01.getOverlays().add(
							new MyOverLay(gp1, gp2, 2, color));

					Log.d("xxx", "pair:" + pairs[i]);

				}
				mMapView01.getOverlays().add(new MyOverLay(dest, dest, 3)); // use
																			// the
																			// default
																			// color
			}
		} catch (MalformedURLException e) {
			// printstack exception
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParserConfigurationException e) {

			e.printStackTrace();

		} catch (SAXException e) {

			e.printStackTrace();
		}

	}

	private void updateWithNewLocation(Location location) {
		String latLong;

		myLocation = (TextView) findViewById(R.id.myLocation);

		String addressString = "no address found";

		if (location != null) {
			double lat = location.getLatitude();
			double lon = location.getLongitude();
			latLong = "Lat:" + lat + "\nLong:" + lon;

			double lattitude = location.getLatitude();
			double longitude = location.getLongitude();

			p = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));
			Geocoder gc = new Geocoder(this, Locale.getDefault());
			try {
				List<Address> addresses = gc.getFromLocation(lattitude,
						longitude, 1);
				StringBuilder sb = new StringBuilder();
				if (addresses.size() > 0) {
					Address address = (Address) addresses.get(0);
					for (int i = 0; i > 0; sb.append(address.getAddressLine(i))
							.append("\n"))
						sb.append(address.getLocality()).append("\n");
					sb.append(address.getPostalCode()).append("\n");
					sb.append(address.getCountryName());
				}
				addressString = sb.toString();
			}

			catch (Exception e) {
			}
		} else {
			latLong = " NO Location Found ";
		}
		myLocation.setText("your Current Position is :\n" + latLong + "\n "
				+ addressString);
	}

	@Override
	protected boolean isRouteDisplayed() {
		//
		return false;
	}

}
