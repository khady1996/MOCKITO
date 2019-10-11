package eu.ensup.analysetodeployment.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import eu.ensup.analysetodeployment.dao.IMedecinDao;
import eu.ensup.analysetodeployment.domaine.Medecin;
import eu.ensup.analysetodeployment.service.MedecinService;

public class TestMedecinService {

	/**
	 * Test unitaire de la classe MedecinService
	 */
	@Test
	public void testLectureMedecin() {

		/*
		 * Scénario du test : La demande de lecture d'informations d'un médecin à partir
		 * de son identifiant nous ramène la totalité de ses caractéristiques.
		 */

		// TODO 1. Mocker l'interface du DAO

		IMedecinDao dao = Mockito.mock(IMedecinDao.class);

		// 2. Créer le service

		MedecinService service = new MedecinService(dao);

		// 3a. Imposer un comportement au mock (stubbing)

		Mockito.when(dao.readMedecinbyId(1)).thenReturn(new Medecin(1, null, "OBERLE", "François"));

		// 3.b Appeler une méthode du service (résultat réel)

		Medecin medecinRetour = service.lireMedecin(1);

		// 4. Comparer le résultat réel avec le résultat attendu

		Assert.assertEquals(medecinRetour.getIdmed(), 1);
		Mockito.verify(dao).readMedecinbyId(1);
	}
}
