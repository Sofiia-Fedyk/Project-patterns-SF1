package creational.prototype;

public class Shape implements Cloneable {
    private String type;
    private int x;
    private int y;
    private String color;

    public Shape(String type, int x, int y, String color) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setPosition(int x, int y) { this.x = x; this.y = y; }
    public void setColor(String color) { this.color = color; }

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return type + "{x=" + x + ", y=" + y + ", color='" + color + "'}";
    }
}
