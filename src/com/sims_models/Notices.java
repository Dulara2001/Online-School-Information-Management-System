package com.sims_models;

public class Notices {
	private int NID;
	private String date;
	private String title;
	private String description;
	private Boolean student;
	private Boolean academic;
	
	public Notices(int nID, String date, String title, String description, Boolean student, Boolean academic) {
		NID = nID;
		this.date = date;
		this.title = title;
		this.description = description;
		this.student = student;
		this.academic = academic;
	}

	public int getNID() {
		return NID;
	}

	
	public String getDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getStudent() {
		return student;
	}

	public Boolean getAcademic() {
		return academic;
	}

}