package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

import java.util.Arrays;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int       nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteledig    = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig    = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		if (innlegg == null) return -1;

		/* for (int i = 0; i < this.innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		} */
		// trenger kun å se gjennom de posisjonene som faktisk har innlegg
		for (int i = 0; i < this.getAntall(); i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}

		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (innlegg == null) return false;
		/* for (Innlegg value : this.innleggtabell) {
			if (value != null && value.erLik(innlegg)) {
				return true;
			}
		} */
		// trenger kun å se gjennom de posisjonene som faktisk har innlegg
		for (int i = 0; i < this.nesteledig; i++) {
			if (this.innleggtabell[i].erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return this.nesteledig < this.innleggtabell.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		// hvis inlegget vi får inn faktisk eksisterer og det er ledig plass i liste
		if (innlegg != null && this.ledigPlass() && !this.finnes(innlegg)) {
			this.innleggtabell[this.nesteledig] = innlegg;
			this.nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		String a = "";
		// trenger kun å se gjennom de posisjonene som faktisk har innlegg
		// for (int i = 0; i < innleggtabell.length; i++) {
		for (int i = 0; i < this.nesteledig; i++) {
			a = a + innleggtabell[i].toString();

		}

		return getAntall() + "\n" + a;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nytab = new Innlegg[innleggtabell.length + 20];
		System.arraycopy(this.innleggtabell, 0, nytab, 0, this.innleggtabell.length);
		this.innleggtabell = nytab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (innlegg == null) return false;
		if (this.leggTil(innlegg)) {
			return true;
		} else {
			this.utvid();
			this.leggTil(innlegg);
		}
		return true;
	}

	public boolean slett(Innlegg innlegg) {
		int slettIndex = this.finnInnlegg(innlegg);
		if (slettIndex == -1) {
			return false;
		} else {
			/*
			// denne metoden er den mest riktige av de to, da den vil opprettholde
			// rekkefølgen på alle elementer, men den er mye treigere, spesielt
			// hvis vi skal gjøre operasjonen på store lister
			// slett element ved å sette posisjon i liste til null
			this.innleggtabell[slettIndex] = null;
			// vi må flytte alle elementer bak i listen framover
			int pos = slettIndex + 1;
			while (pos < this.nesteledig) {
				this.innleggtabell[pos-1] = this.innleggtabell[pos];
				pos++;
			}
			this.innleggtabell[pos-1] = null;
			*/

			// hvis rekkefølge ikke er viktig så kan vi flytte siste element
			// til den posisjonen som ble slettet, og sette siste posisjon til null
			// dette er en mye raskere måte å gjøre det på mtp compute
			// da vi slipper å iterere gjennom muligens gigantiske lister
			this.innleggtabell[slettIndex]     = this.innleggtabell[this.nesteledig - 1];
			this.innleggtabell[nesteledig - 1] = null;
			this.nesteledig--;
			return true;
		}

	}

	public int[] search(String keyword) {
		// midlertidig tabell for å holde alle potensielle treff
		int[] tmp = new int[this.nesteledig];
		int   pos = 0;
		for (int i = 0; i < this.nesteledig; i++) {
			// instanceof for å sørge for at innleggene har tekst og cast til tekst
			// sjekk om innlegget har tekststreng keyword
			if (this.innleggtabell[i] instanceof Tekst tekst && tekst.getTekst().contains(keyword)) {
				tmp[pos] = tekst.getId();
				pos++;
			}
		}
		// lag en ny tabell som kun inneholder så mange elementer som det er treff på søket
		int[] resultat = new int[pos];
		System.arraycopy(tmp, 0, resultat, 0, resultat.length);
		return resultat;
	}
}