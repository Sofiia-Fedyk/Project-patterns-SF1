package behavioral.state;

public interface State {
    void handle(TrafficLight context);
    String getColor();
}
