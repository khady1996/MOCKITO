package eu.ensup.analysetodeployment.domaine;

public class Patient extends Personne {

	private int idpat;
	private Medecin med;

	public Patient() {
		super();
	}

	public Patient(int idpat, Medecin med, String nom, String prenom) {
		super(nom, prenom);
		this.idpat = idpat;
		this.med = med;

	}

	public int getIdpat() {
		return this.idpat;
	}

	public Medecin getMed() {
		return this.med;
	}

	public void setIdpat(int idpat) {
		this.idpat = idpat;
	}

	public void setMed(Medecin med) {
		this.med = med;
	}

	@Override
	public String toString() {
		return "Patient [idpat=" + this.idpat + ", med=" + this.med + ", nom=" + super.getNom() + ", prenom="
				+ super.getPrenom() + "]";
	}

}
