package algorithm;
public class FinderResult {
	private Person P1;

	private Person P2;

	public long D;
	public FinderResult(Person p1, Person p2) {
		if (p1.birthDate.getTime() < p2.birthDate.getTime()) {
				P1 = p1;
                P2 = p2;
            }
			else {

                P1 = p2;
				P2 = p1;
			}
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
