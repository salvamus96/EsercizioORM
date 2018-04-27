package it.polito.tdp.esercizioorm.dao;

import it.polito.tdp.esercizioorm.model.Corso;
import it.polito.tdp.esercizioorm.model.CorsoIdMap;
import it.polito.tdp.esercizioorm.model.Studente;

public class TestDAO {

	public static void main(String[] args) {
		
		CorsoIdMap map = new CorsoIdMap ();
		CorsoDAO cdao = new CorsoDAO();
		for (Corso c : cdao.getTuttiCorsi(map))
			System.out.println(c);
		
		StudenteDAO sdao = new StudenteDAO();
		for (Studente s : sdao.getTuttiStudenti()) 
			System.out.println(s);
	}
}
