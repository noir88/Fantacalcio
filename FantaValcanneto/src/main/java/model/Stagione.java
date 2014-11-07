package model;

import java.util.List;

public class Stagione {

	  private int id_stagione;
	  private String anni;
	  private List<Integer> id_partite;
	  private boolean currentSeason;
	  private List<Integer> id_squadre_partecipanti;
	  
	public int getId_stagione() {
		return id_stagione;
	}
	public void setId_stagione(int id_stagione) {
		this.id_stagione = id_stagione;
	}
	public String getAnni() {
		return anni;
	}
	public void setAnni(String anni) {
		this.anni = anni;
	}
	public List<Integer> getId_partite() {
		return id_partite;
	}
	public void setId_partite(List<Integer> id_partite) {
		this.id_partite = id_partite;
	}
	public boolean isCurrentSeason() {
		return currentSeason;
	}
	public void setCurrentSeason(boolean currentSeason) {
		this.currentSeason = currentSeason;
	}
	public List<Integer> getId_squadre_partecipanti() {
		return id_squadre_partecipanti;
	}
	public void setId_squadre_partecipanti(List<Integer> id_squadre_partecipanti) {
		this.id_squadre_partecipanti = id_squadre_partecipanti;
	}
	  
	  
	  
	  
	
}
