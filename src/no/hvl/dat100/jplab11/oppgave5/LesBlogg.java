package no.hvl.dat100.jplab11.oppgave5;

import java.io.*;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class LesBlogg {

	private static final String TEKST = "TEKST";
	private static final String BILDE = "BILDE";

	private LesBlogg() {
	}

	public static Blogg les(String mappe, String filnavn) {

		String filBane = mappe + filnavn;
		Blogg  nyBlogg = null;
		// try-with-resources
		try (BufferedReader file = new BufferedReader(new FileReader(filBane))) {
			System.out.println("Input fil: " + filBane);
			int elementer = Integer.parseInt(file.readLine());
			nyBlogg = new Blogg(elementer);
			for (int i = 0; i < elementer; i++) {
				Innlegg innlegg = null;
				String  type    = file.readLine();
				if (type.equals(TEKST)) {
					innlegg = new Tekst(Integer.parseInt(file.readLine()), file.readLine(), file.readLine(),
					                    Integer.parseInt(file.readLine()), file.readLine());
				} else if (type.equals(BILDE)) {
					innlegg = new Bilde(Integer.parseInt(file.readLine()), file.readLine(), file.readLine(),
					                    Integer.parseInt(file.readLine()), file.readLine(), file.readLine());
				}
				if (!nyBlogg.leggTil(innlegg)) {
					System.out.println("Feil ved lesing fra fil, innlegg " + i + " ikke lagt inn");
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading from file: " + filBane);
		}

		return nyBlogg;

	}
}
