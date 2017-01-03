package it.starbay.gestionebean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CallDatabase 
{
	private String protocol="jdbc:sqlite:";
	private String username="user";
	private String password="user";
	private String dbName="StarBay.db";
	private Properties userInfo;
	
	public CallDatabase()
	{
		userInfo= new Properties();
		userInfo.put("username", username);
		userInfo.put("password", password);
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		String dbUrl = protocol + dbName;
		Connection connection = DriverManager.getConnection(dbUrl,userInfo);
		return (connection);
	}
	
	
	
}
