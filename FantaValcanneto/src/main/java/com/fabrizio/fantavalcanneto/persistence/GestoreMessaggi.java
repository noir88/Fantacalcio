package com.fabrizio.fantavalcanneto.persistence;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Messaggio;
import model.User;

public class GestoreMessaggi {

	
	public void InserisciMessaggio(HttpServletRequest request, String messaggio) throws SQLException{
		
		User user = (User)request.getSession().getAttribute("utentes");
		
		java.util.Date dateTime = new java.util.Date();
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "INSERT INTO messaggi ("
				 		+ "user_id, contenuto, data)"
				 		+"VALUES ("+user.getId_utente()+",'"+messaggio+"','"
				 		+new java.sql.Timestamp((dateTime).getTime())+"');"; 
				
			 st.execute(query);
			
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();

		}
	
	
	public List<Messaggio>getMessaggi (int nMess, HttpServletRequest request) throws SQLException{
		
		List<Messaggio> messaggi = new ArrayList<Messaggio>();
		int count = nMess;
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		try {
			 st = connection.createStatement();
			 String query= "SELECT * FROM messaggi order by DATA DESC";
					 
				
			ResultSet rs =  st.executeQuery(query);
		
			
			while (rs.next() && count > 0){
				Messaggio mex = new Messaggio();
				int id = rs.getInt("user_id");
				mex.setUser_id(id);
				
				String messaggio = rs.getString("contenuto"); 
				mex.setMessaggio(messaggio);
				Timestamp data = rs.getTimestamp("data");
				mex.setData(data);
				
				System.out.println("mex : " +messaggio);
				System.out.println("data: "+data.toString());
				System.out.println("id: "+id);
				
				count --;
				messaggi.add(mex);
			}
			
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return messaggi;
		
	}
	
	public String toDate(Timestamp time){
		Date date = new Date (time.getTime());
	    return new SimpleDateFormat("dd-MM-yyyy - hh:mm ").format(date);
	}
}
