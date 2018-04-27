package it.polito.tdp.esercizioorm.model;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private int matricola;
	private String nome;
	private String cognome;
	private String cds;

	private List <Corso> corsi;
	
	public Studente() {
		corsi = new ArrayList <> ();
	}
	

	public Studente(int matricola, String nome, String cognome, String cds) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
		// importante inserire in entrambi i costruttori
		corsi = new ArrayList <> ();
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
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

	public String getCds() {
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	
	public List<Corso> getCorsi() {
		return corsi;
	}


	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricola;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola != other.matricola)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", cds=" + cds + "]";
	}

}
