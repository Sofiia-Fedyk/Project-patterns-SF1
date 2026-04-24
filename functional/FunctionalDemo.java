package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalDemo {

    // Task 1: Filter odd numbers from a list
    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }

    // Task 2: Find average of a list of doubles
    public static double findAverage(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    // Task 3: Sort strings alphabetically
    public static List<String> sortAlphabetically(List<String> strings) {
        return strings.stream()
                .sorted((a, b) -> a.compareToIgnoreCase(b))
                .collect(Collectors.toList());
    }

    // Task 4: Sum all even numbers
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (a, b) -> a + b);
    }

    // Task 5: Calculate factorial of a given number
    public static long factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .asLongStream()
                .reduce(1L, (a, b) -> a * b);
    }

    // Task 6: Calculate product and sum of all elements
    public static void multiplyAndSum(List<Integer> numbers) {
        long product = numbers.stream()
                .reduce(1, (a, b) -> a * b)
                .longValue();
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("  Sum: " + sum + ", Product: " + product);
    }

    // Task 7: Square each number in a list
    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Task 8: Sort strings by length ascending
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    // Task 9: Count words in a sentence
    public static long countWords(String sentence) {
        return Arrays.stream(sentence.trim().split("\\s+"))
                .filter(w -> !w.isEmpty())
                .count();
    }

    // Task 10: Find first non-empty string
    public static Optional<String> findFirstNonEmpty(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .findFirst();
    }

    // Task 11: Check if all strings start with uppercase
    public static boolean allStartWithUppercase(List<String> strings) {
        return strings.stream()
                .allMatch(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    // Task 12: Find second largest number
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // Task 13: Find largest even number
    public static Optional<Integer> findLargestEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Comparator.naturalOrder());
    }

    public static void run() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.0);
        List<String> strings = Arrays.asList("Banana", "apple", "Cherry", "date", "Elderberry");
        List<String> sentences = Arrays.asList("", "Hello", "", "World", "Java");

        System.out.println("--- Task 1: Filter odd numbers ---");
        System.out.println("  Input:  " + integers);
        System.out.println("  Result: " + filterOddNumbers(integers));

        System.out.println("\n--- Task 2: Average of doubles ---");
        System.out.println("  Input:  " + doubles);
        System.out.println("  Result: " + findAverage(doubles));

        System.out.println("\n--- Task 3: Sort strings alphabetically ---");
        System.out.println("  Input:  " + strings);
        System.out.println("  Result: " + sortAlphabetically(strings));

        System.out.println("\n--- Task 4: Sum of even numbers ---");
        System.out.println("  Input:  " + integers);
        System.out.println("  Result: " + sumEvenNumbers(integers));

        System.out.println("\n--- Task 5: Factorial ---");
        System.out.println("  factorial(5) = " + factorial(5));
        System.out.println("  factorial(7) = " + factorial(7));

        System.out.println("\n--- Task 6: Sum and product of all elements ---");
        System.out.println("  Input:  " + integers);
        multiplyAndSum(integers);

        System.out.println("\n--- Task 7: Square each number ---");
        System.out.println("  Input:  " + integers);
        System.out.println("  Result: " + squareNumbers(integers));

        System.out.println("\n--- Task 8: Sort strings by length ---");
        System.out.println("  Input:  " + strings);
        System.out.println("  Result: " + sortByLength(strings));

        System.out.println("\n--- Task 9: Count words in sentence ---");
        String sentence = "The quick brown fox jumps over the lazy dog";
        System.out.println("  Input:  \"" + sentence + "\"");
        System.out.println("  Result: " + countWords(sentence) + " words");

        System.out.println("\n--- Task 10: First non-empty string ---");
        System.out.println("  Input:  " + sentences);
        System.out.println("  Result: " + findFirstNonEmpty(sentences).orElse("none"));

        System.out.println("\n--- Task 11: All strings start with uppercase ---");
        List<String> upperStrings = Arrays.asList("Hello", "World", "Java");
        List<String> mixedStrings = Arrays.asList("Hello", "world", "Java");
        System.out.println("  " + upperStrings + " -> " + allStartWithUppercase(upperStrings));
        System.out.println("  " + mixedStrings + " -> " + allStartWithUppercase(mixedStrings));

        System.out.println("\n--- Task 12: Second largest number ---");
        System.out.println("  Input:  " + integers);
        System.out.println("  Result: " + findSecondLargest(integers).orElse(-1));

        System.out.println("\n--- Task 13: Largest even number ---");
        System.out.println("  Input:  " + integers);
        System.out.println("  Result: " + findLargestEven(integers).orElse(-1));
    }
}
