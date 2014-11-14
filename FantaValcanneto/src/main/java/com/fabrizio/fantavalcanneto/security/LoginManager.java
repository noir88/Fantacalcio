package com.fabrizio.fantavalcanneto.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import model.Squadra;
import model.User;

import com.fabrizio.fantavalcanneto.persistence.GestoreSquadre;
import com.fabrizio.fantavalcanneto.persistence.PostgresDbConnector;
import com.fabrizio.fantavalcanneto.persistence.UserManager;

public class LoginManager {

	
	public String loginUser(String username, String password, HttpServletRequest request) throws Exception{
		String resultPage;
		
		Md5PasswordEncrypter encrypter = new Md5PasswordEncrypter();
		String hashed_pwd = encrypter.encryptPasswordToMd5(password);
		
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		st = connection.createStatement();
		
		String query = "SELECT username, nome, cognome, ruolo, squadra_corrente_id, email, user_id FROM users "
				+ "WHERE username ='"+username+"' and password_hashed ='"+hashed_pwd+"'";
		
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			User user = new User();
			user.setUserName(rs.getString("username"));
			user.setNome(rs.getString("nome"));
			user.setCognome(rs.getString("cognome"));
			user.setEmail(rs.getString("email"));
			user.setRole(rs.getString("ruolo"));
			setLoginTime(rs.getInt("user_id"));
			user.setSquadra_corrente_id(rs.getInt("squadra_corrente_id"));
			request.getSession().setAttribute("utentes", user);
			
			GestoreSquadre gestoreSquadre = new GestoreSquadre();
			Squadra squadra = new Squadra();
			squadra = gestoreSquadre.fillDatiSquadra(user.getSquadra_corrente_id());
			
			if(squadra.getSquadraId() != 0)
			request.getSession().setAttribute("squadra", squadra);
			
			
			
				resultPage="home";
			
			
		}
		else{
			resultPage="login";
			request.setAttribute("loginError", "Username o password invalidi");
		}
		System.out.println("pagina" +resultPage);
		connection.close();
		return resultPage;
		
	}
	
	public void setLoginTime(int userId) throws SQLException{
		PostgresDbConnector connector = new PostgresDbConnector();
		Connection connection = null;
		connection = connector.connectToDB();
		Statement st;
		
		st = connection.createStatement();
		java.util.Date dateTime = new java.util.Date();
		
		String query = "UPDATE users "
				+"SET last_login ='"+new java.sql.Timestamp((dateTime).getTime())+"'"
				+"WHERE user_id='"+userId+"'";
		
		st.execute(query);
		connection.close();
		
	}
	
	public void logout (HttpServletRequest request){
		request.getSession().invalidate();
	}

		
}
