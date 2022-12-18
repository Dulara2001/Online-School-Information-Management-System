package com.sims_models;

public class Subject {
	private int sbid;
	private String name;
	
	public Subject(int sbid, String name) {
		this.sbid = sbid;
		this.name = name;
	}

	public int getSbid() {
		return sbid;
	}

	public String getName() {
		return name;
	}
	
}