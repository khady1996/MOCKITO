package eu.ensup.analysetodeployment.service;

import eu.ensup.analysetodeployment.dao.IMedecinDao;
import eu.ensup.analysetodeployment.domaine.Medecin;

public class MedecinService implements IMedecinService {

	private Medecin medecin;
	private IMedecinDao dao;

	public MedecinService() {
		super();
	}

	public MedecinService(IMedecinDao dao) {
		super();
		this.dao = dao;
	}

	public MedecinService(Medecin medecin) {
		super();
		this.medecin = medecin;
	}

	public MedecinService(Medecin medecin, IMedecinDao dao) {
		super();
		this.medecin = medecin;
		this.dao = dao;
	}

	@Override
	public Boolean consulterPatient() {

		System.out.println("Le patient " + this.medecin.getP().getNom() + " " + this.medecin.getP().getPrenom()
				+ " est consulté par Docteur " + this.medecin.getNom() + " " + this.medecin.getPrenom() + " \n");
		return true;
	}

	@Override
	public String creerMedecin(Medecin medecin) {

		return this.dao.createMedecin(medecin);
	}

	public IMedecinDao getDao() {
		return this.dao;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	@Override
	public Medecin lireMedecin(int index) {

		return this.dao.readMedecinbyId(index);
	}

	public void setDao(IMedecinDao dao) {
		this.dao = dao;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

}
