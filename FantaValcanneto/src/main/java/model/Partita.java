package model;

import java.util.List;

public class Partita {
	
	private int id_partita;
	private String tipologiaIncontro;
	private boolean iniziata;
	private boolean finita;
	private boolean formazione_chiusa;
	private List<Integer> scontri_id;
	private int stagione_id;
	
	
	public int getId_partita() {
		return id_partita;
	}
	public void setId_partita(int id_partita) {
		this.id_partita = id_partita;
	}
	public String getTipologiaIncontro() {
		return tipologiaIncontro;
	}
	public void setTipologiaIncontro(String tipologiaIncontro) {
		this.tipologiaIncontro = tipologiaIncontro;
	}
	public boolean isIniziata() {
		return iniziata;
	}
	public void setIniziata(boolean iniziata) {
		this.iniziata = iniziata;
	}
	public boolean isFinita() {
		return finita;
	}
	public void setFinita(boolean finita) {
		this.finita = finita;
	}
	public boolean isFormazione_chiusa() {
		return formazione_chiusa;
	}
	public void setFormazione_chiusa(boolean formazione_chiusa) {
		this.formazione_chiusa = formazione_chiusa;
	}
	public List<Integer> getScontri_id() {
		return scontri_id;
	}
	public void setScontri_id(List<Integer> scontri_id) {
		this.scontri_id = scontri_id;
	}
	public int getStagione_id() {
		return stagione_id;
	}
	public void setStagione_id(int stagione_id) {
		this.stagione_id = stagione_id;
	}
	
	
	
}
