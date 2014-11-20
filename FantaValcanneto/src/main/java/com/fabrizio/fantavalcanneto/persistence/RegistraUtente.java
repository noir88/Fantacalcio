package com.fabrizio.fantavalcanneto.persistence;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import model.User;

import com.fabrizio.fantavalcanneto.security.MailSender;
import com.fabrizio.fantavalcanneto.security.Md5PasswordEncrypter;

public class RegistraUtente {
	
	public boolean userRegistrationValidator(User user) throws SQLException{
		
		boolean isOk = true;
		
		if(existsInTable(user.getUserName(), "users", "username") || 
				existsInTable(user.getEmail(), "users", "email"))
			isOk = false;
		
		return isOk;
		
	}
	
	public String registraUtente(User user, HttpServletRequest request) throws Exception{
		String nextPage="";
		String esito="";
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		Md5PasswordEncrypter passwordEncryptor = new Md5PasswordEncrypter();
		String encryptedPassword = passwordEncryptor.encryptPasswordToMd5(user.getPassword());
		
		
		try {
			java.util.Date dateTime = new java.util.Date();
			 st = connection.createStatement();
			 String query= "INSERT INTO users "
				 		+ "(username, password_hashed, nome, cognome, ruolo, squadra_corrente_id, last_login, "
				 		+ "email)"
				 		+ " VALUES ('"+user.getUserName()+"',"
				 				+ " '"+encryptedPassword+"',"
				 				+ " '"+user.getNome()+"',"
				 				+ " '"+user.getCognome()+"',"
				 				+ " 'user',"
				 				+ " '-1',"
				 				+ " '"+new java.sql.Timestamp((dateTime).getTime())+"',"
				 				+ " '"+user.getEmail()+"');";
				 				
			st.execute(query);
			esito="Utente registrato.";
			nextPage="home";
			
			//TODO sistemare interfaccia con gmail
			//MailSender.sendRegistrationNotificationMail(user.getEmail(), user.getNome(), user.getCognome());
			
		} catch (SQLException e) {
			esito="Dati già presenti sul server.";
			nextPage="FormRegistrazione";
			connection.close();
		}
		request.getSession().setAttribute("esitoRegistrazione", esito);
		connection.close();
		return nextPage;
		}
		
		
		
	
	
	public boolean existsInTable(String value, String tableName, String columnName) throws SQLException{
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		
		boolean found = true;
		Statement st;
		try {
			st = connection.createStatement();
			 ResultSet rs = st.executeQuery("SELECT * FROM "+tableName+" WHERE "+columnName+" = '"+value+"'");
			 if (!rs.next()){
				 found = false;
			 }
		} catch (SQLException e) {
			System.out.println("Errore nella query di ricerca del campo "+value+
					" nella colonna "+columnName+" della tabella "+tableName);
		}
		finally {
			connection.close();
		}
		
		return found;
	}
	

	

}
