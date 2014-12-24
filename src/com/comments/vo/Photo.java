package com.comments.vo;

public class Photo {
	private int iid;
	private String iname;
	
	public Photo(int iid, String iname) {
		super();
		this.iid = iid;
		this.iname = iname;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}
	
	
	
}
