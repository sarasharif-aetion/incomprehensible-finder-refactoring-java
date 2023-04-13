package algorithm;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtils {
    static <T, P> List<P> zip(List<T> items, Function2<T, T, P> build) {
        return items.stream()
                .flatMap(outerItem -> items.stream()
                        .filter(innerItem -> outerItem != innerItem)
                        .map(innerPerson -> build.apply(outerItem, innerPerson)))
                .collect(Collectors.toList());
    }
}

@FunctionalInterface
interface Function2<One, Two, Three> {
    Three apply(One one, Two two);
}