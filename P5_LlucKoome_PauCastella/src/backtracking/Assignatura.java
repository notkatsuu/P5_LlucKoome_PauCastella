package backtracking;

import java.util.ArrayList;

public class Assignatura {

	private int codi;

	private String nom;

	private static ArrayList<Assignatura> assignatures = new ArrayList<Assignatura>();

	private static int[][] relacions;

	public Assignatura(int codi, String nom) {
		this.codi = codi;
		this.nom = nom;
		assignatures.add(this);
	}

	public static Assignatura[] getPlaEstudis() {
		return assignatures.toArray(new Assignatura[0]);
	}

	public static int getPerjudicats(int index1, int index2) {
		return relacions[index1][index2];
	}

	public static void setPerjudicats(Assignatura a1, Assignatura a2, int estudiantsPerjudicats) {

		if (relacions == null) {
			int mida = assignatures.size();
			relacions = new int[mida][mida];
		}

		int i1 = assignatures.indexOf(a1);
		int i2 = assignatures.indexOf(a2);

		relacions[i1][i2] = estudiantsPerjudicats;
		relacions[i2][i1] = estudiantsPerjudicats;
	}

	public int curs() {
		return (codi / 100) % 10;
	}

	public static boolean mateixCurs(Assignatura a1, Assignatura a2) {

		if ((a1 == null) || (a2 == null))
			return false;
		return (a1.curs() == a2.curs());

	}

	public String toString() {
		return "Assignatura " + codi + " " + nom;
	}

}
