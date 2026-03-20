package structural.bridge;

public class Radio implements Device {
    @Override public void turnOn()  { System.out.println("  Radio is ON"); }
    @Override public void turnOff() { System.out.println("  Radio is OFF"); }

    @Override
    public void setVolume(int volume) {
        System.out.println("  Radio volume: " + volume);
    }

    @Override public String getName() { return "Radio"; }
}
