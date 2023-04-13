package algorithm;
import java.util.List;
import java.util.Optional;

public class Finder {
	public Optional<Pair> find(List<Person> people, DistanceCriteria distanceCriteria) {
		if (people.size() <= 1) {
			return Optional.empty();
		}

		List<Pair> pairs = buildPairs(people);

		return pairs.stream().reduce(distanceCriteria::pick);
	}

	private List<Pair> buildPairs(List<Person> people) {
		return ListUtils.zip(people, Pair::new);
	}
}
