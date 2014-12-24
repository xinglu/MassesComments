package com.comments.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;
import com.comments.vo.Comments;

public class CommentsDAO extends AbDAO{
	
	public CommentsDAO() {
		// TODO Auto-generated constructor stub
		mDBManger = DBSqlManager.createInstance();
	}
	
	@Override
	public ArrayList getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Comments> getCommentsByShopid(int shopid) throws SQLException{
		mDBManger.initConnect();
		ArrayList<Comments> list = new ArrayList<Comments>();
		String sql = "SELECT comments.* FROM shop, comments where shop.sid = comments.sid and shop.sid = ?";
		Object[] params = new Object[]{shopid};
		mSet = mDBManger.executeQuery(sql, params);
		while(mSet.next()){
			int cid = mSet.getInt("cid");
			int sid = mSet.getInt("sid");
			int pid = mSet.getInt("pid");
			String name = mSet.getString("name");
			String comments = mSet.getString("comments");
			String clevel = mSet.getString("clevel");
			String kouweilevel = mSet.getString("kouweilevel");
			String huanjinglevel = mSet.getString("huanjinglevel");
			String fuwulevel = mSet.getString("fuwulevel");
			String cpermoney = mSet.getString("cpermoney");
			String time = mSet.getString("time");
			Comments comment = new Comments(cid, sid, pid, name, comments, clevel, kouweilevel, huanjinglevel, fuwulevel, cpermoney, time);
			list.add(comment);
			System.out.println(" comments :"+comment.writeToJson().toString());
		}
		
		mDBManger.closeDB();
		
		return list;
	}
}
