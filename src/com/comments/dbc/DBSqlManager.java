package com.comments.dbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comments.factory.IDBCFactory;
import com.comments.factory.MySqlDBCFactory;





public class DBSqlManager {
	
	private PreparedStatement  mPstm;
	private IDatabaseConnection mConn;
	private static DBSqlManager mInstance = null;
	private IDBCFactory mFactory = null;
	private  DBSqlManager(){
		mFactory = new MySqlDBCFactory();
	}
	
	
	public static DBSqlManager createInstance(){
		if(mInstance == null){
			mInstance = new DBSqlManager();
		}
		return mInstance;
	}
	
	public void initConnect(){
		mConn = mFactory.produceDatabaseConnection();
	}
	/**
	 * 设置PrepareStatement对象中Sql语句中的参数
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数列表
	 * @throws SQLException
	 */
	private void setPrepareStatementParams(String sql, Object[] params)
			throws SQLException
	{
		if(mConn == null){
			return;
		}
		
		mPstm = mConn.getConnection().prepareStatement(sql); // 获取对象
		if (params != null)
		{
			for (int i = 0; i < params.length; i++) // 遍历参数列表填充参数
			{
				mPstm.setObject(i + 1, params[i]);
			}
		}
	} 
	
	/**
	 * 执行查询
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数列表
	 * @return 返回ResultSet类型的查询结果
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql, Object[] params)
			throws SQLException
	{ // 执行查询数据库接口
		ResultSet rs = null;
		setPrepareStatementParams(sql, params); // 填充参数
		if(mPstm == null){
			return null;
		}
		rs = mPstm.executeQuery(); // 执行查询操作
		return rs;
	}
	
	/**
	 * 断开数据库
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		if (mPstm != null)
		{
			mPstm.close();
		}
	
		if (mConn != null)
		{
			mConn.close();
			mConn = null;
		}
	}
	
	/**
	 * 更新数据库操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数列表
	 * @return 执行操作的结果
	 * @throws SQLException
	 */
	public boolean executeUpdate(String sql, Object[] params)
			throws SQLException // 执行无返回数据的数据查询，返回值是被改变的书库的数据库项数
	{
		boolean result = false;
		setPrepareStatementParams(sql, params); // 填充参数
		if(mPstm == null){
			return false;
		}
		mPstm.executeUpdate(); // 执行更新
		commitChange();
		result = true;
		return result;
	}

	/**
	 * 提交信息到数据库
	 * 
	 * @throws SQLException
	 */
	private void commitChange() throws SQLException
	{
		if(mConn == null){
			return;
		}
		mConn.getConnection().commit();
	}
}
