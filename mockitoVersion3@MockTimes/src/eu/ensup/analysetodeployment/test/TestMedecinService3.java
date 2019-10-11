package eu.ensup.analysetodeployment.test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import eu.ensup.analysetodeployment.dao.IMedecinDao;
import eu.ensup.analysetodeployment.domaine.Medecin;
import eu.ensup.analysetodeployment.service.MedecinService;

//@RunWith(MockitoJUnitRunner.class)
public class TestMedecinService3 {

	// Mocker l'interface du DAO
	@Mock
	IMedecinDao mockdao;

	// Permet d'effectuer une injection de d�pendance de constructeur, de m�thode ou
	// de champ de la classe MedecinService

	@InjectMocks
	MedecinService service;

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

		// 3a. Imposer un comportement au mock (stubbing)

		Mockito.when(mockdao.readMedecinbyId(1)).thenReturn(new Medecin(1, null, "OBERLE", "Fran�ois"));
//		Mockito.doReturn(new Medecin(1, null, "OBERLE", "Fran�ois")).when(mockdao).readMedecinbyId(1);
		// 3.b Appeler une m�thode du service (r�sultat r�el)

		Medecin medecinRetour = service.lireMedecin(1);

		// 4. Comparer le r�sultat r�el avec le r�sultat attendu

		Assert.assertEquals(medecinRetour.getIdmed(), 1);

		/*
		 * Permet de v�rifier si la fonction "readMedecinbyId(1)" a �t� appel�, au cas
		 * �ch�ant si elle l'a �t� X fois avec "times(X)"
		 */
		Mockito.verify(mockdao, Mockito.times(1)).readMedecinbyId(1);
	}
}
