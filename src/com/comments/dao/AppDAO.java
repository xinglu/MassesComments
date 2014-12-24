package com.comments.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;
import com.comments.vo.App;



public class AppDAO extends AbDAO{

	
	public AppDAO(){
		mDBManger = DBSqlManager.createInstance();
	}
	
	public ArrayList<App> getAll() throws SQLException{
		ArrayList<App> list = new ArrayList<App>();
		String sql = "SELECT * FROM app";
		mDBManger.initConnect();
		mSet = mDBManger.executeQuery(sql, null);
		while(mSet.next()){
			int appid = mSet.getInt("appid");
			String appname = mSet.getString("appname");
			String appimg = mSet.getString("appimg");
			String appinfo = mSet.getString("appinfo");
			App app = new App(appid, appname, appimg, appinfo);
			list.add(app);
		}
		mDBManger.closeDB();
		return list;
	}
}
