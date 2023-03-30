package algorithm;
public class FinderResult {
	public Person P1;
	public Person P2;
	public long D;

	public FinderResult(Person p1, Person p2) {
		P1 = p1;
		P2 = p2;
		D = P2.birthDate.getTime() - P1.birthDate.getTime();
	}

	public FinderResult() {

	}
}
