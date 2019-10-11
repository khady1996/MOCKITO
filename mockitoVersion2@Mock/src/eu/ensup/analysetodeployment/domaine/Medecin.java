package eu.ensup.analysetodeployment.domaine;

public class Medecin extends Personne{

	private int idmed;
	private Patient patient;
	

	public Medecin() {
		super();
	}

	public Medecin(int idmed, Patient p, String nom, String prenom) {
		super(nom, prenom);
		this.idmed = idmed;
		this.patient = p;
		
	}

	public int getIdmed() {
		return this.idmed;
	}

	public Patient getP() {
		return this.patient;
	}

	public void setIdmed(int idmed) {
		this.idmed = idmed;
	}

	public void setP(Patient p) {
		this.patient = p;
	}

	@Override
	public String toString() {
		return "Medecin [idmed=" + this.idmed + ", p=" + this.patient + ", nom=" + super.getNom() + ", prenom=" + super.getPrenom()
				+ "]";
	}

}
