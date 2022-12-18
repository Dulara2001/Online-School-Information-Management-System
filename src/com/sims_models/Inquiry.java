package com.sims_models;

public class Inquiry {
	private int iid;
	private int sid;
	private String email;
	private String title;
	private String inquiry;
	private int responded;

	public Inquiry(int iid, int sid, String title,String email, String inquiry, int responded) {
		this.iid = iid;
		this.sid = sid;
		this.email = email;
		this.title = title;
		this.inquiry = inquiry;
		this.responded = responded;
	}
	
	
	
	public Inquiry(int iid, int sid, String email, String title, String inquiry) {
		this.iid = iid;
		this.sid = sid;
		this.email = email;
		this.title = title;
		this.inquiry = inquiry;
	}



	public String getTitle() {
		return title;
	}

	public int getIid() {
		return iid;
	}

	public int getSid() {
		return sid;
	}

	public String getEmail() {
		return email;
	}

	public String getInquiry() {
		return inquiry;
	}

	public int getResponded() {
		return responded;
	}
}