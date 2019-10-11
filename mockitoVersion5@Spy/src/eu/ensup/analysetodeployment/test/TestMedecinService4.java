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
	 * @Spy ou la spy() m�thode peut �tre utilis� pour envelopper un objet r�el.
	 * Chaque appel, sauf indication contraire, est d�l�gu� � l'objet.
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
		 * Sc�nario du test : La demande de lecture d'informations d'un m�decin � partir
		 * de son identifiant nous ram�ne la totalit� de ses caract�ristiques.
		 */

		// Imposer un comportement au mock (stubbing)

		Mockito.doReturn(new Medecin(1, null, "OBERLE", "Fran�ois")).when(dao).readMedecinbyId(1);

		// Appel de la fonction du dao

		Medecin medecin = dao.readMedecinbyId(1);
		/*
		 * Permet de v�rifier si la fonction "readMedecinbyId(1)" a �t� appel�, au cas
		 * �ch�ant si elle l'a �t� au moins X fois avec "atLeast(X)"
		 */
		Assert.assertEquals(medecin.getIdmed(), 1);
		Mockito.verify(dao, Mockito.atLeast(1)).readMedecinbyId(1);
	}
}
