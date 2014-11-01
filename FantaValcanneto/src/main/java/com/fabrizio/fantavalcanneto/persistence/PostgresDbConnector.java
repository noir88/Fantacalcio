package com.fabrizio.fantavalcanneto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDbConnector {

	
	public Connection connectToDB()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("org.postgresql.Driver");
	      String url = "jdbc:postgresql://localhost:5432/Fantacalcio";
	      conn = DriverManager.getConnection(url,"postgres", "sg7u7s");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
	    return conn;
	  }
	
	
	

}
