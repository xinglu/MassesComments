package com.comments.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.comments.dbc.DBSqlManager;

public abstract class AbDAO {
	protected DBSqlManager mDBManger;
	protected ResultSet mSet;
	
	public abstract ArrayList getAll()throws SQLException;
}
