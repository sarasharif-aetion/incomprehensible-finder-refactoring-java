package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import algorithm.Pair;
import algorithm.FinderParameter;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	Person sue = new Person();
	Person greg = new Person();
	Person sarah = new Person();
	Person mike = new Person();

	@Before
	public void setup() {
		sue.name = "Sue";
		sue.birthDate = new Date(50, 0, 1);
		greg.name = "Greg";
		greg.birthDate = new Date(52, 5, 1);
		sarah.name = "Sarah";
		sarah.birthDate = new Date(82, 0, 1);
		mike.name = "Mike";
		mike.birthDate = new Date(79, 0, 1);
	}

	private void assertPairContains(Optional<Pair> pair, Person firstPerson, Person secondPerson) {
		List<Person> people = List.of(pair.get().P1(), pair.get().P2());
		assertEquals(2, people.size());
		assertTrue(people.contains(firstPerson));
		assertTrue(people.contains(secondPerson));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder();

		Optional<Pair> result = finder.find(list, FinderParameter.One);
		assertTrue(result.isEmpty());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder();

		Optional<Pair> result = finder.find(list, FinderParameter.One);
		assertTrue(result.isEmpty());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder();

		Optional<Pair> result = finder.find(list, FinderParameter.One);

		assertPairContains(result, greg, sue);
	}


	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder();

		Optional<Pair> result = finder.find(list, FinderParameter.Two);

		assertPairContains(result, greg, mike);
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder();

		Optional<Pair> result = finder.find(list, FinderParameter.Two);

		assertPairContains(result, sue, sarah);
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder();

		Optional<Pair> result = finder.find(list, FinderParameter.One);

		assertPairContains(result, sue, greg);
	}

}
