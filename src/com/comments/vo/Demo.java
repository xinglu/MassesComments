package com.comments.vo;

public class Demo {
	private int cid;
	private String name;
	private String sex;
	
	public Demo(int cid, String name, String sex) {
		super();
		this.cid = cid;
		this.name = name;
		this.sex = sex;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
