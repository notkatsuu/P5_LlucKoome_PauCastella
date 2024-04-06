package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import backtracking.Assignatura;
import backtracking.SolucioCalendari;

class testGEISI {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assignatura assig1 = new Assignatura(103111,"Fonaments de la Programació");
		Assignatura assig2 = new Assignatura(103112,"Introducció als Computadors");
		Assignatura assig3 = new Assignatura(103113,"Emprenedoria i Innovació");
		Assignatura assig4 = new Assignatura(103114,"Anglès Professional");
		Assignatura assig5 = new Assignatura(103211,"Programació Avançada");
		Assignatura assig6 = new Assignatura(103212,"Enginyeria del Software I");
		Assignatura assig7 = new Assignatura(103213,"Economia i Empresa per a Enginyers");
		Assignatura assig8 = new Assignatura(103214,"Física");
		Assignatura assig9 = new Assignatura(103311,"Xarxes i Serveis ");
		Assignatura assig10 = new Assignatura(103312,"Sistemes Gestors de Bases de Dades");
		Assignatura assig11 = new Assignatura(103313,"Sistemes d'informació per a les Organitzacions");
		Assignatura assig12 = new Assignatura(103314,"Laboratori d'Aplicacions Internet");
		Assignatura assig13 = new Assignatura(103411,"Laboratori de Software II");
		Assignatura assig14 = new Assignatura(103412,"Gestió de Projectes Inform�tics");
		Assignatura assig15 = new Assignatura(103413,"Comunicació Corporativa i Màrqueting en Internet");

		// els seg�ents n�meros s'han generat de forma aleat�ria
		Assignatura.setPerjudicats(assig1, assig5, 5);
		Assignatura.setPerjudicats(assig1, assig6, 16);
		Assignatura.setPerjudicats(assig1, assig7, 7);
		Assignatura.setPerjudicats(assig1, assig8, 20);
		Assignatura.setPerjudicats(assig1, assig9, 18);
		Assignatura.setPerjudicats(assig1, assig10, 2);
		Assignatura.setPerjudicats(assig1, assig11, 4);
		Assignatura.setPerjudicats(assig1, assig12, 6);
		Assignatura.setPerjudicats(assig1, assig13, 4);
		Assignatura.setPerjudicats(assig1, assig14, 5);
		Assignatura.setPerjudicats(assig1, assig15, 1);
		Assignatura.setPerjudicats(assig2, assig5, 7);
		Assignatura.setPerjudicats(assig2, assig6, 8);
		Assignatura.setPerjudicats(assig2, assig7, 20);
		Assignatura.setPerjudicats(assig2, assig8, 11);
		Assignatura.setPerjudicats(assig2, assig9, 9);
		Assignatura.setPerjudicats(assig2, assig10, 2);
		Assignatura.setPerjudicats(assig2, assig11, 5);
		Assignatura.setPerjudicats(assig2, assig12, 0);
		Assignatura.setPerjudicats(assig2, assig13, 2);
		Assignatura.setPerjudicats(assig2, assig14, 5);
		Assignatura.setPerjudicats(assig2, assig15, 2);
		Assignatura.setPerjudicats(assig3, assig5, 15);
		Assignatura.setPerjudicats(assig3, assig6, 5);
		Assignatura.setPerjudicats(assig3, assig7, 10);
		Assignatura.setPerjudicats(assig3, assig8, 9);
		Assignatura.setPerjudicats(assig3, assig9, 5);
		Assignatura.setPerjudicats(assig3, assig10, 2);
		Assignatura.setPerjudicats(assig3, assig11, 10);
		Assignatura.setPerjudicats(assig3, assig12, 10);
		Assignatura.setPerjudicats(assig3, assig13, 3);
		Assignatura.setPerjudicats(assig3, assig14, 5);
		Assignatura.setPerjudicats(assig3, assig15, 4);
		Assignatura.setPerjudicats(assig4, assig5, 9);
		Assignatura.setPerjudicats(assig4, assig6, 7);
		Assignatura.setPerjudicats(assig4, assig7, 11);
		Assignatura.setPerjudicats(assig4, assig8, 9);
		Assignatura.setPerjudicats(assig4, assig9, 19);
		Assignatura.setPerjudicats(assig4, assig10, 2);
		Assignatura.setPerjudicats(assig4, assig11, 1);
		Assignatura.setPerjudicats(assig4, assig12, 0);
		Assignatura.setPerjudicats(assig4, assig13, 3);
		Assignatura.setPerjudicats(assig4, assig14, 5);
		Assignatura.setPerjudicats(assig4, assig15, 0);
		Assignatura.setPerjudicats(assig5, assig9, 13);
		Assignatura.setPerjudicats(assig5, assig10, 10);
		Assignatura.setPerjudicats(assig5, assig11, 5);
		Assignatura.setPerjudicats(assig5, assig12, 1);
		Assignatura.setPerjudicats(assig5, assig13, 5);
		Assignatura.setPerjudicats(assig5, assig14, 2);
		Assignatura.setPerjudicats(assig5, assig15, 5);
		Assignatura.setPerjudicats(assig6, assig9, 13);
		Assignatura.setPerjudicats(assig6, assig10, 4);
		Assignatura.setPerjudicats(assig6, assig11, 4);
		Assignatura.setPerjudicats(assig6, assig12, 1);
		Assignatura.setPerjudicats(assig6, assig13, 0);
		Assignatura.setPerjudicats(assig6, assig14, 0);
		Assignatura.setPerjudicats(assig6, assig15, 2);
		Assignatura.setPerjudicats(assig7, assig9, 8);
		Assignatura.setPerjudicats(assig7, assig10, 9);
		Assignatura.setPerjudicats(assig7, assig11, 3);
		Assignatura.setPerjudicats(assig7, assig12, 2);
		Assignatura.setPerjudicats(assig7, assig13, 1);
		Assignatura.setPerjudicats(assig7, assig14, 5);
		Assignatura.setPerjudicats(assig7, assig15, 2);
		Assignatura.setPerjudicats(assig8, assig9, 15);
		Assignatura.setPerjudicats(assig8, assig10, 10);
		Assignatura.setPerjudicats(assig8, assig11, 7);
		Assignatura.setPerjudicats(assig8, assig12, 3);
		Assignatura.setPerjudicats(assig8, assig13, 2);
		Assignatura.setPerjudicats(assig8, assig14, 4);
		Assignatura.setPerjudicats(assig8, assig15, 2);
		Assignatura.setPerjudicats(assig9, assig13, 0);
		Assignatura.setPerjudicats(assig9, assig14, 4);
		Assignatura.setPerjudicats(assig9, assig15, 3);
		Assignatura.setPerjudicats(assig10, assig13, 2);
		Assignatura.setPerjudicats(assig10, assig14, 3);
		Assignatura.setPerjudicats(assig10, assig15, 1);
		Assignatura.setPerjudicats(assig11, assig13, 5);
		Assignatura.setPerjudicats(assig11, assig14, 5);
		Assignatura.setPerjudicats(assig11, assig15, 1);
		Assignatura.setPerjudicats(assig12, assig13, 1);
		Assignatura.setPerjudicats(assig12, assig14, 2);
		Assignatura.setPerjudicats(assig12, assig15, 0);

		
		
	}

	@Test
	void test8days() {
		SolucioCalendari resultat = new SolucioCalendari(8 /*nDays*/, 2/*nAssigInADay*/);
		
		// aquesta execuci� pot trigar molt, per aix� posem una parada
		final ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            final Future<Object> f = service.submit(() -> {
                return resultat.start();
            });

            f.get(10000, TimeUnit.SECONDS);
        } catch (final TimeoutException e) {
            System.err.println("Calculation took to long");
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
		
		System.out.println(resultat);
		
		assertEquals(10, resultat.getMillorResultat() );
	}
	/* output:
		Calculation took to long
		
		Millor solucio trobada utilitzant 8 dies: 
		L'assignacio que perjudica a 10 alumnes es la seguent:
		Dia 1:
			Assignatura 103111 Fonaments de la Programaci�
			Assignatura 103211 Programaci� Avan�ada
		Dia 2:
			Assignatura 103112 Introducci� als Computadors
			Assignatura 103314 Laboratori d'Aplicacions Internet
		Dia 3:
			Assignatura 103113 Emprenedoria i Innovaci�
			Assignatura 103312 Sistemes Gestors de Bases de Dades
		Dia 4:
			Assignatura 103114 Angl�s Professional
			Assignatura 103313 Sistemes d'informaci� per a les Organitzacions
		Dia 5:
			Assignatura 103212 Enginyeria del Software I
			Assignatura 103412 Gesti� de Projectes Inform�tics
		Dia 6:
			Assignatura 103213 Economia i Empresa per a Enginyers
			Assignatura 103413 Comunicaci� Corporativa i M�rqueting en Internet
		Dia 7:
			Assignatura 103214 F�sica
		Dia 8:
			Assignatura 103311 Xarxes i Serveis 
			Assignatura 103411 Laboratori de Software II
	 */

}
