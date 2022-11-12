package no.hvl.dat100.jplab11.oppgave2;

public class Bilde extends Tekst {

	private String url;

	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE" + "\n" + getId() + "\n" + getBruker() +
		       "\n" + getDato() + "\n" + getLikes() + "\n" + getTekst() + "\n" + getUrl() + "\n";

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {
		String output = super.toHTML();
		output += "\t\t\t<iframe src='" + this.url + "' height=600 width=800 title='Image'></iframe>\n";
		return output;
	}
}
