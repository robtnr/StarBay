package it.starbay.bean;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.CallDatabase;

public class CallDatabaseTest {
	
	CallDatabase db;
	@Before
	public void setUp() throws Exception 
	{
		db = new CallDatabase();
		assertNotNull(db);
	}

	@After
	public void tearDown() throws Exception 
	{
		db=null;
	}

	@Test
	public void testGetConnection() throws ClassNotFoundException, SQLException 
	{
		Connection connection = db.getConnection();
		assertNotNull(connection);
	}

}
