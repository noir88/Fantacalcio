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
	
	
	public List<String> findAllTeams() throws SQLException{
		
		List<String> squadre = new ArrayList<String>();
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;

		try {
			st = connection.createStatement();
			String query = "SELECT nome" + " FROM squadre "
					+ " WHERE in_current_season = 'True'";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				squadre.add(rs.getString("nome"));
			}

		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		return squadre;
		
	}
	
	public Map<Integer, String> trovaUserSenzaSquadra() throws SQLException {

		Map<Integer, String> users = new HashMap<Integer, String>();

		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;

		try {
			st = connection.createStatement();
			String query = "SELECT user_id, username" + " FROM users "
					+ " WHERE squadra_corrente_id = '-1'";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				users.put(rs.getInt("user_id"), rs.getString("username"));
			}

		} catch (SQLException e) {
			connection.close();
		}
		connection.close();
		return users;
	}

	public void inserisciSquadra(String nomeGiocatore, String nomeSquadra,
			HttpServletRequest request) throws Exception {
		String esito = "";

		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;

		//Ricava l'id del giocatore a partire dall'username
		try {
			st = connection.createStatement();
			String query = "SELECT user_id" + " FROM users "
					+ " WHERE username = '" + nomeGiocatore + "'";

			ResultSet rs = st.executeQuery(query);

			int idGiocatore = -1;

			//Giocatore trovato
			if (rs.next()) {
				idGiocatore = rs.getInt("user_id");
			}
			
			//Crea una squadra, associagli l'id dell'user e ritorna l'id della nuova squadra
			st = connection.createStatement();
			query = "INSERT INTO squadre(" + "nome, id_user" + ")"
					+ "VALUES ('" + nomeSquadra + "', '" + idGiocatore + "'"
					+ ") RETURNING squadra_id; ";

			rs = st.executeQuery(query);

			int team_id = -1;

			//Se tutto è andato a buon fine ho l'id della squadra
			if (rs.next()) {
				team_id = rs.getInt("squadra_id");
			}

			st = connection.createStatement();
			
			//Aggiorno la tabella user associando l'id della squadra creata
			query = "UPDATE users set squadra_corrente_id = '" + team_id
					+ "', WHERE user_id = '" + idGiocatore + "';";
			st.execute(query);

			//Aggiorno la tabella squadre passate dell'utente
			updateSquadrePassateUser(idGiocatore, team_id);

			esito = "Squadra Inserita Correttamente.";

		} catch (SQLException e) {

			esito = "Errore nell'inserimento della squadra.";
			connection.close();
		}
		connection.close();

		request.getSession().setAttribute("inserimentoSquadra", esito);

	}

	public void updateSquadrePassateUser(int id_user, int id_squadra)
			throws SQLException {

		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;

		try {
			st = connection.createStatement();
			String query = "INSERT INTO squadre_passate (id_squadra, id_user)"
					+ " VALUES ('" + id_squadra + "', '" + id_user + "')";

			st.execute(query);

		} catch (SQLException e) {
			connection.close();
		}
		connection.close();

	}

	public Map<Integer, String> retrieveListOfPlayers(
			HttpServletRequest request, String ruolo, int idUser)
			throws SQLException {

		Map<Integer, String> risultato = new HashMap<Integer, String>();

		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;

		try {
			st = connection.createStatement();
			String query = "SELECT * FROM CALCIATORI WHERE ruolo = '"
					+ ruolo
					+ "'"
					+ " AND ID_SQUADRA_CORRENTE = (SELECT SQUADRA_CORRENTE_ID FROM USERS "
					+ "WHERE SQUADRA_CORRENTE_ID ='" + idUser + "');";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				risultato.put(rs.getInt("calciatore_id"), rs.getString("nome"));
			}

			request.setAttribute("giocatori" + idUser + ruolo, risultato);
		} catch (SQLException e) {

			request.setAttribute("errore",
					"Errore nell'estrazione dei giocatori della rosa");
			connection.close();
		}
		connection.close();

		return risultato;

	}

	public Squadra fillDatiSquadra(int idSquadra) throws SQLException {

		Squadra squadra = new Squadra();

		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;

		try {
			st = connection.createStatement();
			String query = "SELECT *" + " FROM squadre "
					+ " WHERE squadra_id = " + idSquadra;

			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
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
