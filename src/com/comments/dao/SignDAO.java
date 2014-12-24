package com.comments.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;
import com.comments.vo.Sign;

public class SignDAO extends AbDAO {

	public SignDAO() {
		// TODO Auto-generated constructor stub
		mDBManger = DBSqlManager.createInstance();
	}
	
	@Override
	public ArrayList<Sign> getAll() throws SQLException {
		// TODO Auto-generated method stub
		mDBManger.initConnect();
		String sql = "select sign.*, users.nickname from sign, users where users.pid =sign.pid";
		mSet = mDBManger.executeQuery(sql, null);
		ArrayList<Sign> list = new ArrayList<Sign>();
		
		while(mSet.next()){
			int signid = mSet.getInt("signid");
			int sid = mSet.getInt("sid");
			int pid = mSet.getInt("pid");
			String name = mSet.getString("name");
			String signcontent = mSet.getString("signcontent");
			String signlevel = mSet.getString("signlevel");
			String signimg = mSet.getString("signimage");
			String signtime = mSet.getString("signtime");
			Sign sign = new Sign(signid, sid, pid, name, signcontent, signlevel, signimg, signtime);
			list.add(sign);
		}
		mDBManger.closeDB();
		return list;
	}
	
	public boolean addSignInfo(Sign sign) throws SQLException{
		mDBManger.initConnect();
		String sql = "INSERT INTO sign(sid,pid,signcontent,signlevel,signimage,signtime) VALUES (?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{
			sign.getSid(),sign.getPid(),sign.getSigncontent(),sign.getSignlevel(),sign.getSignimg(),sign.getSigntime()	
		};
		
		boolean result = mDBManger.executeUpdate(sql, params);
		mDBManger.closeDB();
		return result;
	}
	
	public ArrayList<Sign> getAllByShopsid(int shopsid) throws SQLException{
		mDBManger.initConnect();
		String sql = "select sign.*from sign, shop where shop.sid = sign.sid and shop.sid =?";
		Object[] params = new Object[]{shopsid};
		mSet = mDBManger.executeQuery(sql, params);
		ArrayList<Sign> list = new ArrayList<Sign>();
		
		while(mSet.next()){
			int signid = mSet.getInt("signid");
			int sid = mSet.getInt("sid");
			int pid = mSet.getInt("pid");
			String name = mSet.getString("name");
			String signcontent = mSet.getString("signcontent");
			String signlevel = mSet.getString("signlevel");
			String signimg = mSet.getString("signimage");
			String signtime = mSet.getString("signtime");
			Sign sign = new Sign(signid, sid, pid, name, signcontent, signlevel, signimg, signtime);
			list.add(sign);
		}
		mDBManger.closeDB();
		return list;
	}
	
	

}
