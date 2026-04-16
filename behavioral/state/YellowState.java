package behavioral.state;

public class YellowState implements State {

    @Override
    public void handle(TrafficLight context) {
        System.out.println("  YELLOW — Slow down! Switching to red.");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}
