package com.Android.GscbtFinal;

public class FormofData1 {

	String id;
	String bbname;
	String bloodgrp;
	String stock;
	String wholeblood;
	String packcells;
	String pltcont;
	String frsfrozen;
	String userid;
	String uname;

	private boolean selected;

	public FormofData1(String id,String userid, String bloodgrp, String wholeblood, String packcells,
			String pltcont,String frsfrozen,String uname) {
		super();
		
		this.id = id;
		this.userid = userid;
		this.bloodgrp = bloodgrp;
		this.wholeblood =wholeblood;
		this.packcells = packcells;
		this.pltcont = pltcont;
		this.frsfrozen = frsfrozen;
		this.uname = uname;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public FormofData1(String id, String bbname, String bloodgrp, String stock) {
		super();

		this.id = id;
		this.bbname = bbname;
		this.stock = stock;
		this.bloodgrp = bloodgrp;

	}

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
