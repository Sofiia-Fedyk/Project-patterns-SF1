package behavioral.state;

public class RedState implements State {

    @Override
    public void handle(TrafficLight context) {
        System.out.println("  RED — Stop! Switching to green.");
        context.setState(new GreenState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
