package com.comments.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class Users {
	private int pid;
	private String pname;
	private String ppassword;
	private String nickname;
	private String sex;
	private String domicile;
	private int    account_balance;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(int pid, String pname, String ppassword, String nickname,
			String sex, String domicile, int account_balance) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ppassword = ppassword;
		this.nickname = nickname;
		this.sex = sex;
		this.domicile = domicile;
		this.account_balance = account_balance;
	}
	
	public JSONObject writeToJSon(){
		JSONObject json = new JSONObject();
		try {
			json.put("pid", pid);
			json.put("pname", pname);
			json.put("ppassword", ppassword);
			json.put("nickname", nickname);
			json.put("sex",sex);
			json.put("domicile", domicile);
			json.put("account_balance", account_balance);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPpassword() {
		return ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public int getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	
	
}
