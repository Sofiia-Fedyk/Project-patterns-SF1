package structural.bridge;

// Abstraction — holds a reference to the Device implementation (the bridge)
public abstract class RemoteControl {
    protected final Device device;

    public RemoteControl(Device device) { this.device = device; }

    public void turnOn()  { device.turnOn(); }
    public void turnOff() { device.turnOff(); }
}
