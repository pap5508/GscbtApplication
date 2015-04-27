package com.Android.GscbtFinal;

public class FormofData {

	String id;
	String bbname;
	String eventname;
	String eventtitle;
	String approve;
	String startdate;
	String enddate;
	String lat;
	String lon;
	String description;

	private boolean selected;

	/*
	 * public FormofData(String id, String bbname, String eventname, String
	 * startdate, String lat, String lon) { super(); this.id = id; this.bbname =
	 * bbname; this.eventname = eventname; this.startdate = startdate; this.lat
	 * = lat; this.lon = lon; }
	 */

	public FormofData(String id, String eventtitle, String approve,
			String startdate, String enddate, String description) {
		super();
		this.id = id;
		this.eventtitle = eventtitle;
		this.approve = approve;
		this.startdate = startdate;
		this.enddate = enddate;
		this.description = description;

	}

	public FormofData(String id, String eventname, String bbname,
			String startdate, String enddate, String lat, String lon,
			String description) {
		super();
		this.id = id;
		this.eventname = eventname;
		this.bbname = bbname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.lat = lat;
		this.lon = lon;
		this.description = description;
	}

	/*
	 * public FormofData(String lat, String lon) { super(); this.lat = lat;
	 * this.lon = lon; }
	 */
	public String getEventtitle() {
		return eventtitle;
	}

	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
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

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
