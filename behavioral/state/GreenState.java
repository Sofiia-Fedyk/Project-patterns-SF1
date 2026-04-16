package behavioral.state;

public class GreenState implements State {

    @Override
    public void handle(TrafficLight context) {
        System.out.println("  GREEN — Go! Switching to yellow.");
        context.setState(new YellowState());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}
