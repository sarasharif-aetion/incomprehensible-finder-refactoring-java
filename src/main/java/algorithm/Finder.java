package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	public Optional<Pair> find(List<Person> people, FinderParameter finderParameter) {
		if (people.size() <= 1) {
			return Optional.empty();
		}

		List<Pair> pairs = buildPairs(people);


		Pair answer = pairs.get(0);
		for (Pair result : pairs) {
			switch (finderParameter) {
				case One :
					if (result.D() < answer.D()) {
						answer = result;
					}
					break;

				case Two :
					if (result.D() > answer.D()) {
						answer = result;
					}
					break;
			}
		}

		return Optional.of(answer);
	}

	private List<Pair> buildPairs(List<Person> people) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				pairs.add(new Pair(people.get(i), people.get(j)));
			}
		}
		return pairs;
	}
}
