package no.hvl.dat100.jplab11.oppgave1;

public abstract class Innlegg {

	private int    id;
	private String bruker;
	private String dato;
	private int    likes;

	protected Innlegg() {

	}

	protected Innlegg(int id, String bruker, String dato) {
		this.id     = id;
		this.bruker = bruker;
		this.dato   = dato;
		this.likes  = 0;
	}

	protected Innlegg(int id, String bruker, String dato, int likes) {
		this.id     = id;
		this.bruker = bruker;
		this.dato   = dato;
		this.likes  = likes;
	}

	public String getBruker() {
		return this.bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return this.dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return this.id;
	}

	public int getLikes() {
		return this.likes;
	}

	public void doLike() {
		this.likes++;
	}

	public boolean erLik(Innlegg innlegg) {
		// sjekk om det andre innlegget faktisk eksisterer
		if (innlegg == null) return false;

		// true hvis de er lik, false hvis ulik
		return id == innlegg.getId();
	}

	@Override
	public String toString() {
		return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return "\t\t<h2>" + this.bruker + "@" + this.dato + " [" + this.likes + "]</h2>" + "\n";
	}
}
