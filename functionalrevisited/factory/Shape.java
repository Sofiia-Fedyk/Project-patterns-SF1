package functionalrevisited.factory;

public interface Shape {
    String name();

    default void draw() {
        System.out.println("Drawing: " + name());
    }

    class Circle implements Shape {
        @Override
        public String name() {
            return "Circle";
        }
    }

    class Square implements Shape {
        @Override
        public String name() {
            return "Square";
        }
    }
}
