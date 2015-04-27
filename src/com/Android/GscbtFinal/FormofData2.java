package com.Android.GscbtFinal;

public class FormofData2 {

	String donorname, district, email, id, bg, bgsign;

	public FormofData2(String donorname, String district, String email,
			String id, String bg, String bgsign) {
		super();
		this.donorname = donorname;
		this.district = district;
		this.email = email;
		this.id = id;
		this.bg = bg;
		this.bgsign = bgsign;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public String getBgsign() {
		return bgsign;
	}

	public void setBgsign(String bgsign) {
		this.bgsign = bgsign;
	}

	public String getDonorname() {
		return donorname;
	}

	public void setDonorname(String donorname) {
		this.donorname = donorname;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
