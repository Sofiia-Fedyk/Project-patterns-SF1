package structural.flyweight;

// Flyweight — stores intrinsic (shared) state: name, color, texture
public class TreeType {
    private final String name;
    private final String color;

    public TreeType(String name, String color) {
        this.name    = name;
        this.color   = color;
    }

    // Extrinsic state (x, y position) is passed in at draw time, not stored
    public void draw(int x, int y) {
        System.out.println("  Drawing " + name + " [" + color + "] at (" + x + ", " + y + ")");
    }

    public String getName() { return name; }
}
