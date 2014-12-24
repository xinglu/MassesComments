package com.comments.vo;

public class Collection {
	private int collectid;
	private int sid;
	private String pname;
	public Collection(int collectid, int sid, String pname) {
		super();
		this.collectid = collectid;
		this.sid = sid;
		this.pname = pname;
	}
	public int getCollectid() {
		return collectid;
	}
	public void setCollectid(int collectid) {
		this.collectid = collectid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
