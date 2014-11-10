package model;

public class Calciatore {
	private int idCalciatore;
	private String nome;
	private int idSquadraCorrente;
	private int[] idScontriGiocati;
	private String ruolo;
	private String squadraReale;
	
	
	public int getIdCalciatore() {
		return idCalciatore;
	}
	public void setIdCalciatore(int idCalciatore) {
		this.idCalciatore = idCalciatore;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdSquadraCorrente() {
		return idSquadraCorrente;
	}
	public void setIdSquadraCorrente(int idSquadraCorrente) {
		this.idSquadraCorrente = idSquadraCorrente;
	}
	public int[] getIdScontriGiocati() {
		return idScontriGiocati;
	}
	public void setIdScontriGiocati(int[] idScontriGiocati) {
		this.idScontriGiocati = idScontriGiocati;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getSquadraReale() {
		return squadraReale;
	}
	public void setSquadraReale(String squadraReale) {
		this.squadraReale = squadraReale;
	}
	
}
