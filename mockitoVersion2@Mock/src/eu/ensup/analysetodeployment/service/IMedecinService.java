package eu.ensup.analysetodeployment.service;

import eu.ensup.analysetodeployment.domaine.Medecin;

public interface IMedecinService {

	public Boolean consulterPatient();

	public String creerMedecin(Medecin medecin);

	public Medecin lireMedecin(int index);

}
