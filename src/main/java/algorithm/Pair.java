package algorithm;
public class Pair {

	private Person person1;

	private Person person2;

	public long distance;

	public Pair(Person person1, Person person2) {
		this.person1 = person1;
		this.person2 = person2;
		distance = Math.abs(this.person2.birthDate.getTime() - this.person1.birthDate.getTime());
	}

	public Person person1() {
		return person1;
	}

	public Person person2() {
		return person2;
	}

	public long distance() {
		return distance;
	}

}
