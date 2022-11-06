package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private final Innlegg[] innleggtabell;
	private       int       nesteledig;

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
		for (int i = 0; i < this.innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}

		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (innlegg == null) return false;
		for (Innlegg value : this.innleggtabell) {
			if (value != null && value.erLik(innlegg)) {
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
		if (innlegg != null && this.ledigPlass()) {
			this.innleggtabell[this.nesteledig] = innlegg;
			this.nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}