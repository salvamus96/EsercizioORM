package it.polito.tdp.esercizioorm.model;

import java.util.List;

import it.polito.tdp.esercizioorm.dao.CorsoDAO;
import it.polito.tdp.esercizioorm.dao.StudenteDAO;

public class Model {
	
	private CorsoDAO cdao;
	private StudenteDAO sdao;
	private List <Corso> corsi;
	private List <Studente> studenti;

	private CorsoIdMap corsoMap;
	
	public Model () {
		cdao = new CorsoDAO ();
		sdao = new StudenteDAO ();
		corsoMap = new CorsoIdMap ();
		
		corsi = cdao.getTuttiCorsi(corsoMap);
		System.out.println(corsi.size());
		
		studenti = sdao.getTuttiStudenti();
		System.out.println(studenti.size());
		
		// inserisco i riferimenti incrociati alle due tabelle
		for (Studente s : studenti) {
			cdao.getCorsiFromStudente(s, corsoMap);
		}
		
	}

	
	public int getTotCreditiFromStudente(int matricola) {
		
		return 0;
	}

}
