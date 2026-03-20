package structural.flyweight;

// Context — holds extrinsic (unique) state: position
// Delegates drawing to the shared TreeType flyweight
public class Tree {
    private final int x, y;
    private final TreeType type; // reference to shared flyweight object

    public Tree(int x, int y, TreeType type) {
        this.x    = x;
        this.y    = y;
        this.type = type;
    }

    public void draw() { type.draw(x, y); }
}
