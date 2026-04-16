package behavioral.visitor;

// Concrete visitor — calculates area without modifying shape classes
public class AreaCalculator implements Visitor {

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.printf("  Circle   (r=%.1f): area = %.2f%n", circle.getRadius(), area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        System.out.printf("  Rectangle (%.1f x %.1f): area = %.2f%n",
                rectangle.getWidth(), rectangle.getHeight(), area);
    }

    @Override
    public void visit(Triangle triangle) {
        double area = 0.5 * triangle.getBase() * triangle.getHeight();
        System.out.printf("  Triangle  (b=%.1f, h=%.1f): area = %.2f%n",
                triangle.getBase(), triangle.getHeight(), area);
    }
}
