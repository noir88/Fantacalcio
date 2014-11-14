package com.fabrizio.fantavalcanneto.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Squadra;

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
	
	
	public Map<Integer,String> retrieveListOfPlayers(HttpServletRequest request, String ruolo, int idUser) throws SQLException{
		
		Map<Integer,String> risultato = new HashMap<Integer,String>();
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT * FROM CALCIATORI WHERE ruolo = '" +ruolo+"'"
			 +" AND ID_SQUADRA_CORRENTE = (SELECT SQUADRA_CORRENTE_ID FROM USERS "
			 + "WHERE SQUADRA_CORRENTE_ID ='"+idUser+"');";
            

			 ResultSet rs = st.executeQuery(query);
			 
			 while(rs.next()){
				 risultato.put(rs.getInt("calciatore_id"), rs.getString("nome"));
			 }
			
				
				request.setAttribute("giocatori"+idUser+ruolo, risultato);
		} catch (SQLException e) {
			
			request.setAttribute("errore", "Errore nell'estrazione dei giocatori della rosa");
			connection.close();
		}
		connection.close();
		
		return risultato;
		
	}
	
	public Squadra fillDatiSquadra(int idSquadra) throws SQLException{
		
		Squadra squadra = new Squadra();
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT *"
				 		+ " FROM squadre "
				 		+ " WHERE squadra_id = " +idSquadra;
				 				
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				squadra.setSquadraId(idSquadra);
				squadra.setNomeSquadra(rs.getString("nome"));
				squadra.setInCurrentSeason(rs.getBoolean("in_current_season"));
				
			}
			
				
		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		return squadra;
	}
	
	
	}

