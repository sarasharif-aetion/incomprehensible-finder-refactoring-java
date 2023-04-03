package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> p) {
		people = p;
	}

	public Optional<FinderResult> Find(FinderParameter finderParameter) {
		List<FinderResult> results = new ArrayList<>();
		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				results.add(new FinderResult(people.get(i), people.get(j)));
			}
		}

		if (results.size() < 1) {
			return Optional.empty();
		}

		FinderResult answer = results.get(0);
		for (FinderResult result : results) {
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
}
