package model;

import java.util.List;

public class Squadra {
	private int squadraId;
	private int userId;
	private String nomeSquadra;

	private boolean inCurrentSeason;

	
	
	
	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
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
	public boolean isInCurrentSeason() {
		return inCurrentSeason;
	}
	public void setInCurrentSeason(boolean inCurrentSeason) {
		this.inCurrentSeason = inCurrentSeason;
	}
	
	
	
}
