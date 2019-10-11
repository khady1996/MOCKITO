package eu.ensup.analysetodeployment.presentation;

import eu.ensup.analysetodeployment.domaine.Medecin;
import eu.ensup.analysetodeployment.domaine.Patient;
import eu.ensup.analysetodeployment.service.MedecinService;

public class Consultation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Medecin medecin = new Medecin(1, null, "OBERLE", "François");
		Patient patient = new Patient(1, medecin, "NDIAYE", "Khady");
		medecin.setP(patient);

		MedecinService medserv = new MedecinService(medecin);

		System.out.println(medserv.consulterPatient());

		// medserv.creerMedecin(medecin);
		// stem.out.println(medserv.LireMedecin(1));

	}

}
