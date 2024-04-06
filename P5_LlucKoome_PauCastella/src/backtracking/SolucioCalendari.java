
package backtracking;

import java.util.Arrays;

public class SolucioCalendari {

	private final Assignatura[] assignatures;
	private final int nDays;
	private final int nAssigInADay;
	
	int[][] solActual;
	int[][] millorSol;

	private int sumaActual = 0;
	private int minAfectats = Integer.MAX_VALUE;

	public SolucioCalendari(int nDays, int nAssigInADay) throws IllegalArgumentException {

		if (nDays * nAssigInADay < Assignatura.getPlaEstudis().length)
			throw new IllegalArgumentException("Ha de superar el nombre de dies minims per a fer l'assignacio");

		this.nDays = nDays; // creacio dels arrays on guardar les solucions
		this.nAssigInADay = nAssigInADay; // creacio dels arrays on guardar les solucions

		this.assignatures = Assignatura.getPlaEstudis();

		this.solActual = new int[nDays][nAssigInADay];
		this.millorSol = new int[nDays][nAssigInADay];
		for (int i = 0; i < nDays; i++) {
			Arrays.fill(solActual[i], -1);
			Arrays.fill(millorSol[i], -1);



		}

		

	}

	public Runnable start() {
		backMillorSolucio(0);
		System.out.println(this);
		return null;
	}

	private void backMillorSolucio(int k) {

		for (int j = 0; j < nDays; j++) { // Iterem per a cada dia
			int[] diaActual = solActual[j]; 
			int primer = diaActual[0]; 
			int segon = diaActual[1]; // hardcode de nAssignInADay = 2 per temes de optimització i de restriccions de
										// l'enunciat mateix, tot i que tècnicament ho permeti
			int quin = 0;
			if (esAcceptable(primer, segon, k)) { // acceptable 1 (no fem mètode apart)
				int perjudicatsAra = 0;
				if (primer != -1) { // si ja he assignat una assignatura al dia
					quin++;
					perjudicatsAra = Assignatura.getPerjudicats(primer, k);
				}

				diaActual[quin] = k;
				sumaActual += perjudicatsAra;

				if (esMillor(sumaActual)) // es Completable i millor de moment
					if (k == assignatures.length - 1) // és solució
						clona();
					else // falten valors per omplir
						backMillorSolucio(k + 1);

				diaActual[quin] = -1;
				sumaActual -= perjudicatsAra;
			}
		}
	}

	private boolean esMillor(int quantitat) {
		return quantitat < minAfectats;

	}

	private boolean esAcceptable(int primer, int segon, int k) {
		return !(segon != -1 || (primer != -1 && Assignatura.mateixCurs(assignatures[primer], assignatures[k])));
		// si ni el segon està ple ni el primer i el k són del mateix curs
	}

	public int getMillorResultat() {
		return minAfectats;
	}

	public String toString() {
		StringBuilder visualitzacio = new StringBuilder(
				"Millor solucio trobada utilitzant " + nDays + " dies: \nL'assignacio que perjudica a "
						+ minAfectats
						+ " alumnes es la seguent:");
		int i = 1;
		for (int[] dia : millorSol) {
			visualitzacio.append("\nDia ").append(i).append(":");
			for (Integer assig : dia) {
				if (assig != -1)
					visualitzacio.append("\n    ").append(assignatures[assig].toString());
			}
			i++;
		}
		return visualitzacio.toString();
	}

	private void clona() {
		for (int i = 0; i < nDays; i++) {
			millorSol[i] = solActual[i].clone();
		}
		minAfectats = sumaActual;
	}
}
