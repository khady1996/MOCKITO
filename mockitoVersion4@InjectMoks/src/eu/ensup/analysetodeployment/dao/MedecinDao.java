package eu.ensup.analysetodeployment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import eu.ensup.analysetodeployment.domaine.Medecin;

public class MedecinDao implements IMedecinDao {

	public AccesBd bd = new AccesBd();

	@Override
	public String createMedecin(Medecin medecin) {

		this.bd.seConnecter();

		try {

			String requete = "INSERT INTO `Medecin` (`idmed`,`nom`,`prenom`) VALUES ('" + medecin.getIdmed() + "','"
					+ medecin.getNom() + "','" + medecin.getPrenom() + "');";

			this.bd.st.executeUpdate(requete);

		} catch (SQLException e) {

			e.printStackTrace();
			return "Erreur lors de l'exécution de la requête : médecin non créé";
		}

		this.bd.seDeconnecter();

		return "Médecin créé avec succés";
	}

	@Override
	public Medecin readMedecinbyId(int index) {
		// TODO Auto-generated method stub
		Medecin medecin = null;

		this.bd.seConnecter();
		try {

			String requete = "SELECT * FROM `Medecin` WHERE `idmed` = '" + index + "';";
			ResultSet rs = this.bd.st.executeQuery(requete);

			while (rs.next()) {
				medecin = new Medecin(rs.getInt("idmed"), null, rs.getString("nom"), rs.getString("prenom"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		this.bd.seDeconnecter();

		return medecin;
	}
}
