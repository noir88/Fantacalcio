package com.fabrizio.fantavalcanneto.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestoreSquadre {

	public Map<Integer, String> trovaUserSenzaSquadra() throws SQLException{
		
		Map<Integer, String> users = new HashMap<Integer, String>();
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT user_id, username"
				 		+ " FROM users "
				 		+ " WHERE squadra_corrente_id = '-1'";
				 				
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				users.put(rs.getInt("user_id"),rs.getString("username"));
			}
				
		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		return users;
		}
	
	
	}

