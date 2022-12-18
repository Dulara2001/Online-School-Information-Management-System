package com.sims_models;

public class Timetables {
	private int ttid;
	private int tid;
	private int year;
	private int grade;
	private String className;
	private String image;
	
	public Timetables(int tid, int year, int grade, String className, String image) {
		this.ttid = 0;
		this.tid = tid;
		this.year = year;
		this.grade = grade;
		this.className = className;
		this.image = image;
	}


	public Timetables(int ttid, int tid, int year, int grade, String className, String image) {
		this.ttid = ttid;
		this.tid = tid;
		this.year = year;
		this.grade = grade;
		this.className = className;
		this.image = image;
	}

	
	public int getTtid() {
		return ttid;
	}

	public int getYear() {
		return year;
	}

	public int getGrade() {
		return grade;
	}

	public String getClassName() {
		return className;
	}

	public String getImage() {
		return image;
	}

	public int getTid() {
		return tid;
	}
}