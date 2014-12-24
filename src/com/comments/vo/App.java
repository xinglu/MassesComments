package com.comments.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class App {
	private int appid;
	private String appname;
	private String appimg;
	private String appinfo;
	
	public App(int appid, String appname, String appimg, String appinfo) {
		super();
		this.appid = appid;
		this.appname = appname;
		this.appimg = appimg;
		this.appinfo = appinfo;
	}
	
	public JSONObject writeToJson(){
		JSONObject json = new JSONObject();
		try {
			json.put("appid", appid);
			json.put("appname", appname);
			json.put("appimg", appimg);
			json.put("appinfo", appinfo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getAppimg() {
		return appimg;
	}

	public void setAppimg(String appimg) {
		this.appimg = appimg;
	}

	public String getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(String appinfo) {
		this.appinfo = appinfo;
	}
	
	
	
}
