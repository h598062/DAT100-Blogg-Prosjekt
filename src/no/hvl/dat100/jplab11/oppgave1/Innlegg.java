package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {
	// TODO - deklarering av objektvariable

	private int id;
	private String bruker;
	private String dato;
	private int likes;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = 0;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		
		throw new UnsupportedOperationException(TODO.constructor("Innlegg"));
	}
	
	public String getBruker() {
		return this.bruker;
	}

	public void setBruker(String bruker) {
		throw new UnsupportedOperationException(TODO.method());
	}

	public String getDato() {
		return this.dato;
	}

	public void setDato(String dato) {
		throw new UnsupportedOperationException(TODO.method());
	}

	public int getId() {
		return this.id;
	}

	public int getLikes() {
		return this.likes;
	}
	
	public void doLike () {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean erLik(Innlegg innlegg) {
		throw new UnsupportedOperationException(TODO.method());

	}
	
	@Override
	public String toString() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
