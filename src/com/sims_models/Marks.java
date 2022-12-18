package com.sims_models;

public class Marks {
	private int sid, sbid, grade;
	private String exam, sub;
	private double result;
	
	public Marks(int sid, int sbid, int grade, String exam, double result) {
		this.sid = sid;
		this.sbid = sbid;
		this.grade = grade;
		this.exam = exam;
		this.result = result;
	}
	
	public Marks(int sid, String sub, int grade, String exam, double result) {
		this.sid = sid;
		this.sub = sub;
		this.grade = grade;
		this.exam = exam;
		this.result = result;
	}
	
	public String getSub() {
		return sub;
	}

	public Marks(int sbid, int grade, String exam) {
		this.sid = 0;
		this.sbid = sbid;
		this.grade = grade;
		this.exam = exam;
		this.result = 0.0;
	}

	public int getSid() {
		return sid;
	}

	public int getSbid() {
		return sbid;
	}

	public int getGrade() {
		return grade;
	}

	public String getExam() {
		return exam;
	}

	public double getResult() {
		return result;
	}
	
	
	
	
}
