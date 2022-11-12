package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}

	private static final String HTMLPREFIX =
			"<!DOCTYPE html>\n<html lang='no'>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";

	private static final String HTMLPOSTFIX =
			"\t</body>\n</html>";

	@Override
	public String toString() {
		if (this.getAntall() == 0) return HTMLPREFIX + HTMLPOSTFIX;
		StringBuilder output  = new StringBuilder(HTMLPREFIX);
		Innlegg[]     innlegg = this.getSamling();
		for (int i = 0; i < this.getAntall(); i++) {
			String hr = "<hr>";
			output.append(innlegg[i].toHTML());
			output.append("\t\t\t").append(hr).append("\n").append("\n");
		}
		output.append(HTMLPOSTFIX);
		return output.toString();
	}
}
