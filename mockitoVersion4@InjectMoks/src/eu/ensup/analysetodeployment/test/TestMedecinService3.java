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

	// Permet d'effectuer une injection de dépendance de constructeur, de méthode ou
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
		 * Scénario du test : La demande de lecture d'informations d'un médecin à partir
		 * de son identifiant nous ramène la totalité de ses caractéristiques.
		 */

		// 3a. Imposer un comportement au mock (stubbing)

		Mockito.when(mockdao.readMedecinbyId(1)).thenReturn(new Medecin(1, null, "OBERLE", "François"));
//		Mockito.doReturn(new Medecin(1, null, "OBERLE", "François")).when(mockdao).readMedecinbyId(1);
		// 3.b Appeler une méthode du service (résultat réel)

		Medecin medecinRetour = service.lireMedecin(1);

		// 4. Comparer le résultat réel avec le résultat attendu

		Assert.assertEquals(medecinRetour.getIdmed(), 1);

		/*
		 * Permet de vérifier si la fonction "readMedecinbyId(1)" a été appelé, au cas
		 * échéant si elle l'a été X fois avec "times(X)"
		 */
		Mockito.verify(mockdao, Mockito.times(1)).readMedecinbyId(1);
	}
}
