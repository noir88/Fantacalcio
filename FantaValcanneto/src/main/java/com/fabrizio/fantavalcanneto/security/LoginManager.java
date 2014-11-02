package com.fabrizio.fantavalcanneto.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.fabrizio.fantavalcanneto.User;
import com.fabrizio.fantavalcanneto.persistence.PostgresDbConnector;

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
		
		String query = "SELECT username, nome, cognome, email, descrizione FROM users,ruoli "
				+ "WHERE username ='"+username+"' and password_hashed ='"+hashed_pwd+"'"
				+"and users.ruolo_id = ruoli.id_ruolo";
		
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			User user = new User();
			user.setUserName(rs.getString("username"));
			user.setNome(rs.getString("nome"));
			user.setCognome(rs.getString("cognome"));
			user.setEmail(rs.getString("email"));
			user.setRole(rs.getString("descrizione"));
			
			SessionManager.session().setAttribute("user", user);
			resultPage="home";
			
		}
		else{
			resultPage="login";
			request.setAttribute("loginError", "Username o password invalidi");
		}
		System.out.println("pagina" +resultPage);
		return resultPage;
		
	}
	

		
}
