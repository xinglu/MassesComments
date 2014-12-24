package com.comments.vo;

public class Order {
	private int orderid;
	private int sid;
	private String pname;
	private int ordernum;
	private int playflag;
	public Order(int orderid, int sid, String pname, int ordernum, int playflag) {
		super();
		this.orderid = orderid;
		this.sid = sid;
		this.pname = pname;
		this.ordernum = ordernum;
		this.playflag = playflag;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getPlayflag() {
		return playflag;
	}
	public void setPlayflag(int playflag) {
		this.playflag = playflag;
	}
	
	
}
