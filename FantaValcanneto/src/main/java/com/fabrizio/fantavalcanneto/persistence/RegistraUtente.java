package com.fabrizio.fantavalcanneto.persistence;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

import com.fabrizio.fantavalcanneto.User;
import com.fabrizio.fantavalcanneto.security.Md5PasswordEncrypter;

public class RegistraUtente {
	
	public boolean userRegistrationValidator(User user) throws SQLException{
		
		boolean isOk = true;
		
		if(existsInTable(user.getUserName(), "users", "username") || 
				existsInTable(user.getEmail(), "users", "email"))
			isOk = false;
		
		return isOk;
		
	}
	
	public boolean registraUtente(User user) throws SQLException, NoSuchAlgorithmException{
		
		Boolean inserito = true;
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDatabase();
		Statement st;
		
		Md5PasswordEncrypter passwordEncryptor = new Md5PasswordEncrypter();
		String encryptedPassword = passwordEncryptor.encryptToMd5(user.getPassword());
		
		try {
			java.util.Date dateTime = new java.util.Date();
			 st = connection.createStatement();
			 String query= "INSERT INTO users "
				 		+ "(username, password_hashed, nome, cognome, ruolo_id, squadra_corrente_id, last_login, "
				 		+ "email)"
				 		+ " VALUES ('"+user.getUserName()+"',"
				 				+ " '"+encryptedPassword+"',"
				 				+ " '"+user.getNome()+"',"
				 				+ " '"+user.getCognome()+"',"
				 				+ " '1',"
				 				+ " '-1',"
				 				+ " '"+new java.sql.Timestamp((dateTime).getTime())+"',"
				 				+ " '"+user.getEmail()+"');";
				 				
			st.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return inserito;
		
		
	}
	
	public boolean existsInTable(String value, String tableName, String columnName) throws SQLException{
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDatabase();
		
		boolean found = true;
		Statement st;
		try {
			st = connection.createStatement();
			 ResultSet rs = st.executeQuery("SELECT * FROM "+tableName+" WHERE "+columnName+" = "'"+value+"'");
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
