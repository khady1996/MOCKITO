package eu.ensup.analysetodeployment.test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import eu.ensup.analysetodeployment.dao.IMedecinDao;
import eu.ensup.analysetodeployment.dao.MedecinDao;
import eu.ensup.analysetodeployment.domaine.Medecin;

//@RunWith(MockitoJUnitRunner.class)
public class TestMedecinService4 {

	/*
	 * @Spy ou la spy() méthode peut être utilisé pour envelopper un objet réel.
	 * Chaque appel, sauf indication contraire, est délégué à l'objet.
	 *
	 */

	@Spy
	IMedecinDao dao = new MedecinDao();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test unitaire de la classe MedecinService
	 */
	@Test
	public void testLectureMedecin() {

		/*
		 * Scénario du test : La demande de lecture d'informations d'un médecin à partir
		 * de son identifiant nous ramène la totalité de ses caractéristiques.
		 */

		// Imposer un comportement au mock (stubbing)

		Mockito.doReturn(new Medecin(1, null, "OBERLE", "François")).when(dao).readMedecinbyId(1);

		// Appel de la fonction du dao

		Medecin medecin = dao.readMedecinbyId(1);
		/*
		 * Permet de vérifier si la fonction "readMedecinbyId(1)" a été appelé, au cas
		 * échéant si elle l'a été au moins X fois avec "atLeast(X)"
		 */
		Assert.assertEquals(medecin.getIdmed(), 1);
		Mockito.verify(dao, Mockito.atLeast(1)).readMedecinbyId(1);
	}
}
