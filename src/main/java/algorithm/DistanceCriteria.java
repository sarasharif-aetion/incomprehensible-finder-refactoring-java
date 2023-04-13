package algorithm;

public enum DistanceCriteria {
	Closest {
		@Override
		Pair pick(Pair pair1, Pair pair2) {
			return pair1.distance() > pair2.distance() ? pair2 : pair1;
		}
	},
	Furthest {
		@Override
		Pair pick(Pair pair1, Pair pair2) {
			return pair1.distance() < pair2.distance() ? pair2 : pair1;
		}
	};

	abstract Pair pick(Pair pair1, Pair pair2);
}
