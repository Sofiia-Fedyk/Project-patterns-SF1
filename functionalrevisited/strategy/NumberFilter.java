package functionalrevisited.strategy;

import java.util.List;
import java.util.function.Predicate;

public class NumberFilter {
    public static int sum(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
                .filter(selector)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
