package functionalrevisited;

import functionalrevisited.strategy.NumberFilter;
import functionalrevisited.factory.Shape;
import functionalrevisited.decorator.TextTransformer;
import functionalrevisited.executearound.FileManager;

import java.util.Arrays;
import java.util.List;

public class FunctionalRevisitedDemo {

    public static void run() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("--- Strategy ---");
        System.out.println("List " + numbers);
        System.out.println("Sum of all:          " + NumberFilter.sum(numbers, n -> true));
        System.out.println("Sum of even only:    " + NumberFilter.sum(numbers, n -> n % 2 == 0));
        System.out.println("Sum of numbers > 5:  " + NumberFilter.sum(numbers, n -> n > 5));

        System.out.println("\n--- Factory Method ---");
        new Shape.Circle().draw();
        new Shape.Square().draw();

        System.out.println("\n--- Decorator ---");
        String input = "  hello  ";
        System.out.println("Input: \"" + input + "\"");
        System.out.println("No transform:                \"" + new TextTransformer().apply(input) + "\"");
        System.out.println("Trim only:                   \"" + new TextTransformer(String::trim).apply(input) + "\"");
        System.out.println("Trim + toUpperCase:          \"" + new TextTransformer(String::trim, String::toUpperCase).apply(input) + "\"");
        System.out.println("Trim + toUpperCase + spaces: \"" + new TextTransformer(String::trim, String::toUpperCase, s -> s.replace(" ", "_")).apply(input) + "\"");

        System.out.println("\n--- Execute Around ---");
        FileManager.use(f -> f.read().write());
    }
}
