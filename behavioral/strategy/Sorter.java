package behavioral.strategy;

// Context — delegates sorting to the chosen strategy
public class Sorter {

    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] data) {
        System.out.println("  Using " + strategy.getName() + ":");
        strategy.sort(data);
    }
}
