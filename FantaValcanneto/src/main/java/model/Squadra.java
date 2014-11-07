package model;

import java.util.List;

public class Squadra {
	private int squadraId;
	private int userId;
	private String nomeSquadra;
	private List<Integer> stagioniGiocateId;
	private boolean inCurrentSeason;
	private List<Integer> giocatoriCorrentiId;
	private List<Integer> scontriGiocatiId;
	
	
	
	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}
	
	
	public List<Integer> getScontriGiocatiId() {
		return scontriGiocatiId;
	}

	public void setScontriGiocatiId(List<Integer> scontriGiocatiId) {
		this.scontriGiocatiId = scontriGiocatiId;
	}

	public int getSquadraId() {
		return squadraId;
	}
	
	public void setSquadraId(int squadraId) {
		this.squadraId = squadraId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Integer> getStagioniGiocateId() {
		return stagioniGiocateId;
	}
	public void setStagioniGiocateId(List<Integer> stagioniGiocateId) {
		this.stagioniGiocateId = stagioniGiocateId;
	}
	public boolean isInCurrentSeason() {
		return inCurrentSeason;
	}
	public void setInCurrentSeason(boolean inCurrentSeason) {
		this.inCurrentSeason = inCurrentSeason;
	}
	public List<Integer> getGiocatoriCorrentiId() {
		return giocatoriCorrentiId;
	}
	public void setGiocatoriCorrentiId(List<Integer> giocatoriCorrentiId) {
		this.giocatoriCorrentiId = giocatoriCorrentiId;
	}
	
	
	
}
