package it.polito.tdp.esercizioorm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esercizioorm.model.Corso;
import it.polito.tdp.esercizioorm.model.CorsoIdMap;
import it.polito.tdp.esercizioorm.model.Studente;

public class CorsoDAO {
	
	public List<Corso> getTuttiCorsi(CorsoIdMap corsoMap) {
		
		String sql = "SELECT codins, crediti, nome, pd FROM corso" ;
		List<Corso> result = new ArrayList<>() ;
		
		try {
			Connection conn = ConnectDBCP.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Corso c = new Corso(res.getString("codins"),
						res.getInt("crediti"),
						res.getString("nome"),
						res.getInt("pd") ) ;
				
				// result.add(c) ;
				// in questo modo aggiungo solo corsi non precedentemente nell'Identity Map
				result.add(corsoMap.get(c));
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		return result;
	}

	public void getCorsiFromStudente(Studente studente, CorsoIdMap corsoMap) {

		String sql = "SELECT c.codins, crediti, nome, pd FROM corso as c, iscrizione as i WHERE c.codins = i.codins and i.matricola = ?" ;
	
		try {
			Connection conn = ConnectDBCP.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, studente.getMatricola());
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Corso c = new Corso(res.getString("codins"),
						res.getInt("crediti"),
						res.getString("nome"),
						res.getInt("pd") ) ;
				
				// aggiugo il corso dato dall'Identity Map alla lista dei corsi dello studente passato come parametro
				studente.getCorsi().add(corsoMap.get(c));

			}		
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}

	}
	
}	
	
	