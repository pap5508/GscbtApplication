package com.Android.GscbtFinal;

public class FormofData3 {
	String lon;
	String id;
	String bbname;
	String lat;
	String city;
	String bg;
	String stock;
	String address;
	String phoneno;
	String wholeblood;
	String packcells;
	String pltcont;
	String frsfrozen;
	String userid;

	private boolean selected;

	public FormofData3(String userid) {
		super();

		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public FormofData3(String id, String bbname, String bg, String city,
			String stock, String lat, String lon, String address) {
		super();

		this.id = id;
		this.bbname = bbname;
		this.stock = stock;
		this.lat = lat;
		this.lon = lon;
		this.bg = bg;
		this.city = city;
		this.address = address;

	}

	public FormofData3(String id, String bg, String wholeblood,
			String packcells, String pltcont, String frsfrozen, String stock) {
		super();

		this.id = id;
		this.bg = bg;
		this.wholeblood = wholeblood;
		this.packcells = packcells;
		this.pltcont = pltcont;
		this.frsfrozen = frsfrozen;
		this.stock = stock;

	}

	public FormofData3(String id, String bbname, String address, String city,
			String bg, String wholeblood, String packcells, String pltcont,
			String frsfrozen) {
		super();

		this.id = id;
		this.bbname = bbname;
		this.address = address;
		this.city = city;
		this.bg = bg;
		this.wholeblood = wholeblood;
		this.packcells = packcells;
		this.pltcont = pltcont;
		this.frsfrozen = frsfrozen;

	}

	public FormofData3(String id, String bbname, String address, String city,
			String bg, String wholeblood, String packcells, String pltcont,
			String frsfrozen, String phoneno) {
		super();

		this.id = id;
		this.bbname = bbname;
		this.address = address;
		this.city = city;
		this.bg = bg;
		this.wholeblood = wholeblood;
		this.packcells = packcells;
		this.pltcont = pltcont;
		this.frsfrozen = frsfrozen;
		this.phoneno = phoneno;

	}

	public String getWholeblood() {
		return wholeblood;
	}

	public void setWholeblood(String wholeblood) {
		this.wholeblood = wholeblood;
	}

	public String getPackcells() {
		return packcells;
	}

	public void setPackcells(String packcells) {
		this.packcells = packcells;
	}

	public String getPltcont() {
		return pltcont;
	}

	public void setPltcont(String pltcont) {
		this.pltcont = pltcont;
	}

	public String getFrsfrozen() {
		return frsfrozen;
	}

	public void setFrsfrozen(String frsfrozen) {
		this.frsfrozen = frsfrozen;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getBbname() {
		return bbname;
	}

	public void setBbname(String bbname) {
		this.bbname = bbname;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
