package model;

public class User {
	private int id_utente;
    private String userName;
    private String nome;
    private String cognome;
    private String password;
    private String email;
    private String role;
    private int squadra_corrente_id;
    
	public int getSquadra_corrente_id() {
		return squadra_corrente_id;
	}
	public void setSquadra_corrente_id(int squadra_corrente_id) {
		this.squadra_corrente_id = squadra_corrente_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public boolean isUser(){
		return this.getRole().equals("user");
	}
	
	public boolean isAdmin(){
		return this.getRole().equals("admin");
	}
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
  
     
}