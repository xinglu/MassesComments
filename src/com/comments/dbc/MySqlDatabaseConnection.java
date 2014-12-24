package com.comments.dbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MySqlDatabaseConnection implements IDatabaseConnection {

	private Connection connection;
	private String DSNAME = "java:comp/env/jdbc/massescomments";
	
	public MySqlDatabaseConnection(){
		
		try {
			Context context = new InitialContext();
			DataSource source = (DataSource) context.lookup(DSNAME);
			connection = source.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub

		return this.connection;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		if(this.connection !=null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
