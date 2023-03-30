package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> p) {
		people = p;
	}

	public FinderResult Find(FinderParameter finderParameter) {
		List<FinderResult> results = new ArrayList<FinderResult>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					results.add(new FinderResult(people.get(i), people.get(j)));
				} else {
					results.add(new FinderResult(people.get(j), people.get(i)));
				}
			}
		}

		if (results.size() < 1) {
			return new FinderResult();
		}

		FinderResult answer = results.get(0);
		for (FinderResult result : results) {
			switch (finderParameter) {
				case One :
					if (result.D < answer.D) {
						answer = result;
					}
					break;

				case Two :
					if (result.D > answer.D) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
