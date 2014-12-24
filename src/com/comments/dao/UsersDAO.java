package com.comments.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;
import com.comments.vo.Users;

public class UsersDAO extends AbDAO {

	public UsersDAO() {
		// TODO Auto-generated constructor stub
		mDBManger = DBSqlManager.createInstance();
	}

	@Override
	public ArrayList<Users> getAll() throws SQLException {
		// TODO Auto-generated method stub

		return null;
	}

	public Users getUsers(String pname, String ppassword) throws SQLException {
		mDBManger.initConnect();
		String sql = "select * from users where pname =? and ppassword =?";
		Object[] params = new Object[] { pname, ppassword };
		mSet = mDBManger.executeQuery(sql, params);
		Users users = null;
		if (mSet.next()) {
			int pid = mSet.getInt("pid");
			String pname1 = mSet.getString("pname");
			String ppassword1 = mSet.getString("ppassword");
			String nickname = mSet.getString("nickname");
			String sex = mSet.getString("sex");
			String domicile = mSet.getString("domicile");
			int account_balance = mSet.getInt("account_balance");
			users = new Users(pid, pname1, ppassword1, nickname, sex, domicile, account_balance);
			System.out.println("  users: "+users.writeToJSon().toString());
		}
		mDBManger.closeDB();
		return users;
	}
	
	public boolean addUsers(Users user) throws SQLException{
		mDBManger.initConnect();
		String sql = "insert into users(pname, ppassword, nickname, sex, domicile, account_balance) values(?, ?, ?, ?, 100)";
		Object[] params = new Object[]{user.getPname(),user.getPpassword(),user.getNickname(),user.getSex(),user.getDomicile()};
		boolean result = mDBManger.executeUpdate(sql, params);
		mDBManger.closeDB();
		return result;
	}
}
