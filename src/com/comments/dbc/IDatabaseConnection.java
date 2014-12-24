package com.comments.dbc;

import java.sql.Connection;



public interface IDatabaseConnection {
	public Connection getConnection();
	public void close();
}
