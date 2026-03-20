package structural.bridge;

// Refined abstraction — extends remote with volume control
public class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) { super(device); }

    public void setVolume(int volume) { device.setVolume(volume); }
}
