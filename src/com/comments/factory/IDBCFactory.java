package com.comments.factory;

import com.comments.dbc.IDatabaseConnection;

public interface IDBCFactory {
	public IDatabaseConnection produceDatabaseConnection();
}
