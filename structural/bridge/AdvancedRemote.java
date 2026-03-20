package structural.bridge;

// Refined abstraction — extends remote with mute functionality
public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("  " + device.getName() + " muted");
        device.setVolume(0);
    }
}
