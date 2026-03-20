package structural.decorator;

// Component interface that both concrete coffee and decorators implement
public interface Coffee {
    String getDescription();
    double getCost();
}
