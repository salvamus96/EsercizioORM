package it.polito.tdp.esercizioorm.model;

import java.util.List;

import it.polito.tdp.esercizioorm.dao.CorsoDAO;
import it.polito.tdp.esercizioorm.dao.StudenteDAO;

public class Model {

	private CorsoDAO cdao;
	private StudenteDAO sdao;
	
	private List<Corso> corsi;
	private List<Studente> studenti;
	
	private CorsoIdMap corsomap;
	
	public Model() {
		
		cdao = new CorsoDAO();
		sdao = new StudenteDAO();
		
		corsomap = new CorsoIdMap();
		
		corsi = cdao.getTuttiCorsi(corsomap);
		System.out.println(corsi.size());
		
		studenti = sdao.getTuttiStudenti();
		System.out.println(studenti.size());
		
		for (Studente s : studenti) {
			cdao.getCorsiFromStudente(s, corsomap);
		}
	}
	
	public int getTotCreditiFromStudente(int matricola) {
		// TODO Auto-generated method stub
		return 0;
	}

}
