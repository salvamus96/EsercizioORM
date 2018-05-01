package it.polito.tdp.esercizioorm.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

			Model m = new Model ();
			
//			int matricola = 146101;
//			int result = m.getTotCreditiFromStudente(matricola);
//			System.out.println("Tot crediti: " + result + "\n");
//			
//			List <Studente> resultStudenti = m.getStudentiFromCorso("01NBAPG");
//			for (Studente s : resultStudenti)
//				System.out.println(s);
//			System.out.println("\n");
//			
//			List <Corso> resultCorsi = m.getCorsiFromStudente(matricola);
//			for (Corso c : resultCorsi)
//				System.out.println(c);
//			System.out.println("\n");
	
			m.testCP();
			// provo prima con ConnectDB poi con ConnectDBCP, i risultati sono in basso

//			CONNECT DB			
//			0.3735222726
//			0.458536221
//			0.2681020611
//			0.268083121
//			0.3223561718
//			0.3638903218
//			0.3318716588
//			0.292825697
//			0.2900200436
//			0.3285235173
//			AvgTime (mean on 10 loops): 0.3297731086


			
// 			CONNECT DB WITH CONNECTION POOLING
//			0.0538053479
//			0.0390041294
//			0.0433049232
//			0.0324568008
//			0.0346331698
//			0.0318852609
//			0.0302104202
//			0.0401330429
//			0.0411465191
//			0.0312315443
//			AvgTime (mean on 10 loops): 0.03778111585	
			
			
	}
}
