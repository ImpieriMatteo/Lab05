package it.polito.tdp.angrammi.model;

public class Anagramma {
	
	private String anagramma;
	private boolean corretto;
	
	public Anagramma(String anagramma) {
		this.anagramma = anagramma;
		this.corretto = false;
	}

	public String getAnagramma() {
		return anagramma;
	}

	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

}
