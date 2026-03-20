package structural.bridge;

// Implementation interface — the "other side" of the bridge
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    String getName();
}
