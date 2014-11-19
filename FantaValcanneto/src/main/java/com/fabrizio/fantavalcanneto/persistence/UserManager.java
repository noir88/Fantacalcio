package com.fabrizio.fantavalcanneto.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	
	
	public String trovaNomeSquadra(int idSquadra) throws SQLException{
		String nomeSquadra = "";
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT nome"
				 		+ " FROM squadre "
				 		+ " WHERE squadra_id = " +idSquadra;
				 				
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				nomeSquadra = rs.getString("nome");
			}
			
				
		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		return nomeSquadra;
	}
	
	
	public String trovaNomeUtente(int idGiocatore) throws SQLException{
		String nomeGiocatore = "";
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT username"
				 		+ " FROM users "
				 		+ " WHERE user_id = " +idGiocatore;
				 				
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				nomeGiocatore = rs.getString("username");
			}
			
				
		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		return nomeGiocatore;
	}

}
