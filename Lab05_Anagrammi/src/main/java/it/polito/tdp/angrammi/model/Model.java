package it.polito.tdp.angrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	private DizionarioDAO dizionarioDAO;
	
	public Model() {
		this.dizionarioDAO = new DizionarioDAO();
	}

	public List<Anagramma> cercaAnagrammi(String parola) {
		List<Anagramma> risultato = new ArrayList<>();
		
		this.permuta("", parola, 0, risultato);
		this.isCorrect(risultato);
		
		return risultato;
	}
	
	private void permuta(String parziale, String lettere, int livello, List<Anagramma> risultato) {
		if( lettere.length()==0 ) { 
			
			Anagramma temp = new Anagramma(parziale);
			risultato.add(temp);
		} else {
			
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos) ; 
				
				String nuovaParziale = parziale + tentativo ;
				String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;
			}
		}
	}
	
	private void isCorrect(List<Anagramma> risultato) {
		for(Anagramma a : risultato) {
			if(dizionarioDAO.isPresent(a.getAnagramma()))
				a.setCorretto(true);
		}
	}

}
