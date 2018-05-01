package it.polito.tdp.esercizioorm.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esercizioorm.dao.CorsoDAO;
import it.polito.tdp.esercizioorm.dao.StudenteDAO;

public class Model {
	
	private CorsoDAO cdao;
	private StudenteDAO sdao;
	private List <Corso> corsi;
	private List <Studente> studenti;

	private CorsoIdMap corsoMap;
	private StudenteIdMap studenteMap;
	
	public Model () {
		cdao = new CorsoDAO ();
		sdao = new StudenteDAO ();
		
		corsoMap = new CorsoIdMap ();
		studenteMap = new StudenteIdMap ();
		
		corsi = cdao.getTuttiCorsi(corsoMap);
		System.out.println(corsi.size());
		
		studenti = sdao.getTuttiStudenti(studenteMap);
		System.out.println(studenti.size());
		
		// inserisco i riferimenti incrociati alle due tabelle
		for (Studente s : studenti) {
			cdao.getCorsiFromStudente(s, corsoMap);
		}
		
		for (Corso c : corsi) {
			sdao.getStudentiFromCorso(c, studenteMap);
		}
		
	}
	
	
	public List <Studente> getStudentiFromCorso (String codins){
		// ottengo il corso con il codins passato come parametro
		Corso c = corsoMap.get(codins);
		
		// controllo se il get restitusce un oggetto Corso
		if (c == null)
			return new ArrayList<Studente> (); // ritorna una lista vuota
		
		return c.getStudenti();
	}

	public List <Corso> getCorsiFromStudente (int matricola){
		
		Studente s = studenteMap.get(matricola);
		// altrimenti si può andare incontro a un NullPointerException
		if (s == null)
			return new ArrayList <Corso> ();
		
		return s.getCorsi();
	}
	
	public int getTotCreditiFromStudente(int matricola) {
// non serve una query, ho tutto in memoria
		int sum = 0;
		
		for (Studente s : studenti) {
		// data lo studente con la matricola passata come parametro ciclo sulla lista dei suoi corsi	
			if (s.getMatricola() == matricola) {
				for (Corso c : s.getCorsi()) {
					sum += c.getCrediti();
				}
				return sum;
			}
		}		
// nel caso in cui la matricola passata come parametro non ha alcuna corrispondenza
		return -1; 
	}

	public boolean iscriviStudenteACorso (int matricola, String codins) {
		Studente studente = studenteMap.get(matricola);
		Corso corso = corsoMap.get(codins);
		
		if (studente == null || corso == null)
			return false;
		
// occorre aggiornare il database e poi successivamente i riferimenti in memoria RAM
		boolean result = sdao.iscriviStudenteACorso (studente, corso);

		if (result) {
			// aggiornamento DB con successo perciò posso aggiornare i riferimenti in memoria
			if (!studente.getCorsi().contains(corso)) // per evitare i duplicati 
				studente.getCorsi().add(corso);
			if (!corso.getStudenti().contains(studente))
				corso.getStudenti().add(studente);
			return true;
		}
		
		return false;
	}
	
	
	
	
	/**
	 *Questo metodo viene utilizzato solo per testare le performance di ConnectDBCP. 
	 */
	
	public void testCP() {
		double avgTime = 0;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			List<Studente> studenti = sdao.getTuttiStudenti(new StudenteIdMap());
			for (Studente s : studenti) {
				sdao.studenteIscrittoACorso(s.getMatricola(), "01NBAPG");
			}
			double tt = (System.nanoTime() - start) / 10e9;
			System.out.println(tt);
			avgTime += tt;
		}
		System.out.println("AvgTime (mean on 10 loops): " + avgTime/10);
	}
}
