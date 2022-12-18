package com.sims_models;

public class Teacher {
	private int tid;
	private String name;
	private int age;
	private String address;
	private String contact;
	private int sbid;
	private String profilePic;
	private int auid;
	
	public Teacher(String name, int age, String address, String contact, int sbid, String profilePic, int auid) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.contact = contact;
		this.sbid = sbid;
		this.profilePic = profilePic;
		this.auid = auid;
	}

	public Teacher(int tid, String name, int age, String address, String contact, int sbid, String profilePic, int auid) {
		this.tid = tid;
		this.name = name;
		this.age = age;
		this.address = address;
		this.contact = contact;
		this.sbid = sbid;
		this.profilePic = profilePic;
		this.auid = auid;
	}

	public int getAuid() {
		return auid;
	}


	public void setAuid(int auid) {
		this.auid = auid;
	}

	public int getTid() {
		return tid;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}

	public int getSbid() {
		return sbid;
	}

	public String getProfilePic() {
		return profilePic;
	}
}