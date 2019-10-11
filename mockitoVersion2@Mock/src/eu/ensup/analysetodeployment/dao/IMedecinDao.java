package eu.ensup.analysetodeployment.dao;

import eu.ensup.analysetodeployment.domaine.Medecin;

public interface IMedecinDao {

	public String createMedecin(Medecin medecin);

	public Medecin readMedecinbyId(int index);

}
