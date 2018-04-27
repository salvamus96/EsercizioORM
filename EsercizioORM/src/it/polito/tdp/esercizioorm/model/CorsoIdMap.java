package it.polito.tdp.esercizioorm.model;

import java.util.HashMap;
import java.util.Map;

public class CorsoIdMap {

	private Map <String, Corso> map;
	
	public CorsoIdMap () {
		map = new HashMap <> ();
		
	}
	/**
	 * Verifica se l'oggetto esiste, se non esiste lo crea sul momento
	 */
	public Corso get(Corso corso) {
		Corso old = map.get(corso.getCodIns());
		if (old == null) {
			// nella mappa non � presente il corso passato come parametro
			map.put(corso.getCodIns(), corso);
			return corso;
		}
		return old;
	}
	
	public void put (String codins, Corso corso) {
		map.put(codins, corso);
	}
	
	
	
	
}
