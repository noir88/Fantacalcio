package com.fabrizio.fantavalcanneto.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class GestoreCalciatori {
	
	
	public String creaCalciatore(String ruolo, String nome, String squadraReale, HttpServletRequest request) throws Exception{
		 //in realta torna la stessa pagina con il messaggio di richiesta
		 
		String esito="inserimentoGiocatore";
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "INSERT INTO calciatori("
            +"nome, ruolo, squadra_reale)"
            +"VALUES ('"+nome+"','"+ruolo+"','"+squadraReale+"');";

				 				
			 st.execute(query);
			 
			 //per mostrare nella pagina di inserimento
			 request.setAttribute("giocatoreInserito","Giocatore Inserito Correttamente.");
				
		} catch (SQLException e) {
			request.setAttribute("giocatoreInserito", "Errore nell'inserimento del giocatore");
			connection.close();
		}
		connection.close();
		return esito;
		
		
		
	}
	
	
	
	public String modificaSquadraReale(int idGiocatore, String nuovaSquadra, HttpServletRequest request) throws Exception{
		
		String esito="modificaGiocatore";
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "update calciatori"
            +"set squadra_reale = '"+nuovaSquadra+"' WHERE calciatore_id ='"+idGiocatore+"';";
			 st.execute(query);
			 
			 //per mostrare nella pagina di inserimento
			 request.setAttribute("modificaGiocatore","Giocatore Modificato Correttamente.");
				
		} catch (SQLException e) {
			request.setAttribute("modificaGiocatore", "Errore nella modifica del giocatore");
			connection.close();
		}
		connection.close();
		return esito;
		
	}
	
	public String svincolaGiocatore( int idSquadra, int idStagione, int idGiocatore, HttpServletRequest request) throws Exception{
		
		String esito="modificaGiocatore";
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			java.util.Date dateTime = new java.util.Date();
			 st = connection.createStatement();
			 String query= "update calciatori"
            +"set id_squadra_corrente = '-1' WHERE calciatore_id ='"+idGiocatore+"';";
			 st.execute(query);
			 
			 st = connection.createStatement();
			  query= "update trasferimenti"
            +"set timest_fine = '"+new java.sql.Timestamp((dateTime).getTime())+"' WHERE id = ("
            		+ "SELECT id from trasferimenti where id_giocatore = '"+idGiocatore+"' and id_squadra = '"+idSquadra+" "
            				+ "order by id desc limit 1;')";
			 st.execute(query);
			 
			 
			 
			 st = connection.createStatement();
			 query= "INSERT INTO trasferimenti("
            +"id_giocatore, id_squadra, timest_inizio," 
            +"id_stagione)"
            +"VALUES ('"+idGiocatore+"', '-1', '"+new java.sql.Timestamp((dateTime).getTime())+"','"+idStagione+"');"; 
          
			 st.execute(query);
			 
			 
			 
			 
			 //per mostrare nella pagina di inserimento
			 request.setAttribute("modificaGiocatore","Giocatore svincolato correttamente.");
				
		} catch (SQLException e) {
			request.setAttribute("modificaGiocatore", "Errore nella modifica del giocatore");
			connection.close();
		}
		connection.close();
		return esito;
		
		
	}

}
