package algorithm;
public class Pair {
	private Person P1;

	private Person P2;

	public long D;
	public Pair(Person p1, Person p2) {
		P1 = p1;
		P2 = p2;
		D = Math.abs(P2.birthDate.getTime() - P1.birthDate.getTime());
	}

	public Person P1() {
		return P1;
	}

	public Person P2() {
		return P2;
	}

	public long D() {
		return D;
	}

}
