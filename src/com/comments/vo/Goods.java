package com.comments.vo;
/**
 * 物品类
 * @author zlh
 *
 */
public class Goods {
	
	private int sid;
	private int iid;	   //序号
	private String gname;  //物品名称
	private String gprice; //价格
	
	public Goods(int sid, int iid, String gname, String gprice) {
		super();
		this.sid = sid;
		this.iid = iid;
		this.gname = gname;
		this.gprice = gprice;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGprice() {
		return gprice;
	}

	public void setGprice(String gprice) {
		this.gprice = gprice;
	}
	
	
	
}
