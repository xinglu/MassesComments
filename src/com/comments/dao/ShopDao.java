package com.comments.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;
import com.comments.vo.Shop;

public class ShopDao extends AbDAO {

	public ShopDao() {
		// TODO Auto-generated constructor stub
		mDBManger = DBSqlManager.createInstance();
	}
	@Override
	public ArrayList<Shop> getAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Shop> list = new ArrayList<Shop>();
		mDBManger.initConnect();
		String sql =  "select shop.sid, shop.iid, shop.sname, shop.stype, shop.saddress, shop.snear, shop.stel, " +
				"shop.stime, shop.szhekou, shop.smembercard, shop.sper, shop.smoney, shop.snum, shop.slevel, " +
				"shop.sflag_tuan, shop.sflag_quan, shop.sflag_ding, shop.sflag_ka, shop.longitude, " +
				"shop.latitude, shop.sintroduction,shop.sdetails, shop.stips,sflag_promise, photo.iname " +
				"from shop, photo";
		mSet = mDBManger.executeQuery(sql, null);
		while(mSet.next()){
			Shop shop = new Shop();
			shop.setIid(mSet.getInt("iid"));
			shop.setIname(mSet.getString("iname"));
			shop.setLatitude(mSet.getString("latitude"));
			shop.setLongitude(mSet.getString("longitude"));
			shop.setSaddress(mSet.getString("saddress"));
			shop.setSdetails(mSet.getString("sdetails"));
			shop.setSflag_ding(mSet.getString("sflag_ding"));
			shop.setSflag_ka(mSet.getString("sflag_ka"));
			shop.setSflag_promise(mSet.getString("sflag_promise"));
			shop.setSflag_quan(mSet.getString("sflag_quan"));
			shop.setSflag_tuan(mSet.getString("sflag_tuan"));
			shop.setSid(mSet.getInt("sid"));
			shop.setSintroduction(mSet.getString("sintroduction"));
			shop.setSlevel(mSet.getString("slevel"));
			shop.setSmembercard(mSet.getString("smembercard"));
			shop.setSmoney(mSet.getString("smoney"));
			shop.setSname(mSet.getString("sname"));
			shop.setSnear(mSet.getString("snear"));
			shop.setSnum(mSet.getString("snum"));
			shop.setSper(mSet.getString("sper"));
			shop.setStel(mSet.getString("stel"));
			shop.setStime(mSet.getString("stime"));
			shop.setStips(mSet.getString("stips"));
			shop.setStype(mSet.getString("stype"));
			shop.setSzhekou(mSet.getString("szhekou"));
			list.add(shop);
		}
		mDBManger.closeDB();
		return list;
	}
	
	public ArrayList<Shop>getAllByFilter(int start, int end) throws SQLException{
		ArrayList<Shop> list = new ArrayList<Shop>();
		mDBManger.initConnect();
		String sql =  "select shop.sid, shop.iid, shop.sname, shop.stype, shop.saddress, shop.snear, shop.stel, " +
				"shop.stime, shop.szhekou, shop.smembercard, shop.sper, shop.smoney, shop.snum, shop.slevel, " +
				"shop.sflag_tuan, shop.sflag_quan, shop.sflag_ding, shop.sflag_ka, shop.longitude, " +
				"shop.latitude, shop.sintroduction,shop.sdetails, shop.stips,sflag_promise, photo.iname " +
				"from shop, photo where shop.iid = photo.iid and shop.sid >=? and shop.sid <=?";
		Object[] params = new Object[]{start,end};
		mSet = mDBManger.executeQuery(sql, params);
		while(mSet.next()){
			Shop shop = new Shop();
			shop.setIid(mSet.getInt("iid"));
			shop.setIname(mSet.getString("iname"));
			shop.setLatitude(mSet.getString("latitude"));
			shop.setLongitude(mSet.getString("longitude"));
			shop.setSaddress(mSet.getString("saddress"));
			shop.setSdetails(mSet.getString("sdetails"));
			shop.setSflag_ding(mSet.getString("sflag_ding"));
			shop.setSflag_ka(mSet.getString("sflag_ka"));
			shop.setSflag_promise(mSet.getString("sflag_promise"));
			shop.setSflag_quan(mSet.getString("sflag_quan"));
			shop.setSflag_tuan(mSet.getString("sflag_tuan"));
			shop.setSid(mSet.getInt("sid"));
			shop.setSintroduction(mSet.getString("sintroduction"));
			shop.setSlevel(mSet.getString("slevel"));
			shop.setSmembercard(mSet.getString("smembercard"));
			shop.setSmoney(mSet.getString("smoney"));
			shop.setSname(mSet.getString("sname"));
			shop.setSnear(mSet.getString("snear"));
			shop.setSnum(mSet.getString("snum"));
			shop.setSper(mSet.getString("sper"));
			shop.setStel(mSet.getString("stel"));
			shop.setStime(mSet.getString("stime"));
			shop.setStips(mSet.getString("stips"));
			shop.setStype(mSet.getString("stype"));
			shop.setSzhekou(mSet.getString("szhekou"));
			list.add(shop);
			System.out.println(" shop: "+shop.writeToJson().toString());
		}
		mDBManger.closeDB();
		
		return list;
	}
	
	public ArrayList<Shop>getAllByFilterTuan(int start, int end) throws SQLException{
		ArrayList<Shop> list = new ArrayList<Shop>();
		mDBManger.initConnect();
		String sql =  "select shop.sid, shop.iid, shop.sname, shop.stype, shop.saddress, shop.snear, shop.stel, " +
				"shop.stime, shop.szhekou, shop.smembercard, shop.sper, shop.smoney, shop.snum, shop.slevel, " +
				"shop.sflag_tuan, shop.sflag_quan, shop.sflag_ding, shop.sflag_ka, shop.longitude, " +
				"shop.latitude, shop.sintroduction,shop.sdetails, shop.stips,sflag_promise, photo.iname " +
				"from shop, photo where shop.iid = photo.iid and shop.sflag_tuan = 1 order by shop.sid asc limit ?, ?";
		Object[] params = new Object[]{start,end};
	
		mSet = mDBManger.executeQuery(sql, params);
		while(mSet.next()){
			Shop shop = new Shop();
			shop.setIid(mSet.getInt("iid"));
			shop.setIname(mSet.getString("iname"));
			shop.setLatitude(mSet.getString("latitude"));
			shop.setLongitude(mSet.getString("longitude"));
			shop.setSaddress(mSet.getString("saddress"));
			shop.setSdetails(mSet.getString("sdetails"));
			shop.setSflag_ding(mSet.getString("sflag_ding"));
			shop.setSflag_ka(mSet.getString("sflag_ka"));
			shop.setSflag_promise(mSet.getString("sflag_promise"));
			shop.setSflag_quan(mSet.getString("sflag_quan"));
			shop.setSflag_tuan(mSet.getString("sflag_tuan"));
			shop.setSid(mSet.getInt("sid"));
			shop.setSintroduction(mSet.getString("sintroduction"));
			shop.setSlevel(mSet.getString("slevel"));
			shop.setSmembercard(mSet.getString("smembercard"));
			shop.setSmoney(mSet.getString("smoney"));
			shop.setSname(mSet.getString("sname"));
			shop.setSnear(mSet.getString("snear"));
			shop.setSnum(mSet.getString("snum"));
			shop.setSper(mSet.getString("sper"));
			shop.setStel(mSet.getString("stel"));
			shop.setStime(mSet.getString("stime"));
			shop.setStips(mSet.getString("stips"));
			shop.setStype(mSet.getString("stype"));
			shop.setSzhekou(mSet.getString("szhekou"));
			list.add(shop);
		}
		mDBManger.closeDB();
		
		return list;
	}

}
