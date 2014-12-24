package com.comments.factory;

import com.comments.dbc.IDatabaseConnection;
import com.comments.dbc.MySqlDatabaseConnection;

public class MySqlDBCFactory implements IDBCFactory {

	@Override
	public IDatabaseConnection produceDatabaseConnection() {
		// TODO Auto-generated method stub
		return new MySqlDatabaseConnection();
	}

}
