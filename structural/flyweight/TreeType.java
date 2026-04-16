package structural.flyweight;

public class TreeType {
    private final String name;
    private final String color;

    public TreeType(String name, String color) {
        this.name    = name;
        this.color   = color;
    }

    public void draw(int x, int y) {
        System.out.println("  Drawing " + name + " [" + color + "] at (" + x + ", " + y + ")");
    }

    public String getName() { return name; }
}
