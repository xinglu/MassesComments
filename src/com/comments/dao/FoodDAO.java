package com.comments.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;
import com.comments.vo.Food;

public class FoodDAO extends AbDAO {
	public FoodDAO() {
		// TODO Auto-generated constructor stub
		mDBManger = DBSqlManager.createInstance();
	}
	
	@Override
	public ArrayList<Food> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<Food> getFoodsByShopid(int shopid) throws SQLException{
		mDBManger.initConnect();
		ArrayList<Food> list = new ArrayList<Food>();
		String sql = "select food.* from shop,food where shop.sid = food.sid and shop.sid = ?";
		Object[] objects = new Object[]{shopid};
		mSet = mDBManger.executeQuery(sql, objects);
		while(mSet.next()){
			int foodid =mSet.getInt("foodid");
			int sid = mSet.getInt("sid");
			String foodname = mSet.getString("foodname");
			String foodphotoid = mSet.getString("foodphotoid");
			Food food = new Food(foodid, sid, foodname, foodphotoid);
			list.add(food);
			System.out.println("  food: "+food.writoToJSon().toString());
		}
		mDBManger.closeDB();
		
		return list;
	}
}
