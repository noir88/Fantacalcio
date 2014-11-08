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
	
	public String inserisciSquadra(String nomeGiocatore, String nomeSquadra) throws Exception{
		String esito="admin/FallimentoInserimentoSquadra";
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT user_id"
				 		+ " FROM users "
				 		+ " WHERE username = '"+nomeGiocatore+"'";
				 				
			ResultSet rs = st.executeQuery(query);
			
			int idGiocatore = -1;
			
			if (rs.next()){
				idGiocatore = rs.getInt("user_id");
			}
			
			st = connection.createStatement();
			query = "INSERT INTO squadre("
            +"nome, id_user" 
            +")"
            +"VALUES ('"+nomeSquadra+"', '"+idGiocatore+"'" 
            +") RETURNING squadra_id; ";
			
			rs = st.executeQuery(query);
			
			int team_id = -1;
			
			if(rs.next()){
				team_id = rs.getInt("squadra_id");
			}
			
			st = connection.createStatement();
			
			query = "UPDATE users set squadra_corrente_id = '"+team_id+"' WHERE user_id = '"+idGiocatore+"';";
			st.execute(query);
			
			esito = "/admin/TeamSuccessfullAdded";
			
				
		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		
		return esito;
	}
	
	
	}

