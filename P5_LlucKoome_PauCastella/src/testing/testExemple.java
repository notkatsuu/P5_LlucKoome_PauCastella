package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import backtracking.Assignatura;
import backtracking.SolucioCalendari;

class testExemple {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assignatura assig1 = new Assignatura(103111,"Fonaments de la Programaci�"); 
		Assignatura assig2 = new Assignatura(103211,"Programaci� Avan�ada"); 
		Assignatura assig3 = new Assignatura(103311,"Xarxes i Serveis");
		Assignatura assig4 = new Assignatura(103411,"Laboratori de Software II");  
		Assignatura.setPerjudicats(assig1, assig2, 5);
		Assignatura.setPerjudicats(assig1, assig3, 1);
		Assignatura.setPerjudicats(assig2, assig3, 20);
		Assignatura.setPerjudicats(assig2, assig4, 9);
		Assignatura.setPerjudicats(assig3, assig4, 2);
		
		
	}
	
	@Test
	void test1days() {
		// si el nombre de dies x assignatures per dies �s inferior al nombre d'assignatures cal llen�ar una exception
		assertThrows(IllegalArgumentException.class, ()->{new SolucioCalendari(1 /*nDays*/, 2/*nAssigInADay*/);});

	}

	@Test
	void test2days() {
		SolucioCalendari resultat = new SolucioCalendari(2 /*nDays*/, 2/*nAssigInADay*/);
		resultat.start();
		System.out.println(resultat);
		
		assertEquals(7, resultat.getMillorResultat() );
	}
	/* output:
		Millor solucio trobada utilitzant 2 dies: 
		L'assignacio que perjudica a 7 alumnes es la seguent:
		Dia 1:
			Assignatura 103111 Fonaments de la Programaci�
			Assignatura 103211 Programaci� Avan�ada
		Dia 2:
			Assignatura 103311 Xarxes i Serveis
			Assignatura 103411 Laboratori de Software II
	 */
	
	@Test
	void test3days() {
		SolucioCalendari resultat = new SolucioCalendari(3 /*nDays*/, 2/*nAssigInADay*/);
		resultat.start();
		System.out.println(resultat);
		
		assertEquals(0, resultat.getMillorResultat() );
	}
	/* output:
		Millor solucio trobada utilitzant 3 dies: 
		L'assignacio que perjudica a 0 alumnes es la seguent:
		Dia 1:
			Assignatura 103111 Fonaments de la Programaci�
			Assignatura 103411 Laboratori de Software II
		Dia 2:
			Assignatura 103211 Programaci� Avan�ada
		Dia 3:
			Assignatura 103311 Xarxes i Serveis
	 */

}
