package behavioral.state;

// Context — delegates behavior to the current state object
public class TrafficLight {

    private State state;

    public TrafficLight() {
        this.state = new RedState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void change() {
        state.handle(this);
    }

    public String getCurrentColor() {
        return state.getColor();
    }
}
