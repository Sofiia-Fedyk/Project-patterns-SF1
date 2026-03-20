package structural.decorator;

// Base decorator — wraps a Coffee object and delegates calls to it
public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }

    @Override public String getDescription() { return coffee.getDescription(); }
    @Override public double getCost()        { return coffee.getCost(); }
}
