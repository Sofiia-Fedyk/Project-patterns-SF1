import creational.CreationalDemo;
import structural.StructuralDemo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("DESIGN PATTERNS");
            System.out.println("1. Creational Patterns");
            System.out.println("2. Structural Patterns");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1" -> CreationalDemo.run();
                case "2" -> StructuralDemo.run();
                case "0" -> running = false;
                default -> System.out.println("Invalid option. Try again.\n");
            }
        }

        scanner.close();
        System.out.println("Bye!");
    }
}
