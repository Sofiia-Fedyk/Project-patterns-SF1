package structural.decorator;

// Concrete component — the base object to be decorated
public class SimpleCoffee implements Coffee {
    @Override public String getDescription() { return "Coffee"; }
    @Override public double getCost()        { return 1.00; }
}
