package creational.builder;

public class Computer {
    private final String cpu;
    private final String gpu;
    private final int ram;
    private final int storage;
    private final boolean wifi;
    private final boolean bluetooth;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.wifi = builder.wifi;
        this.bluetooth = builder.bluetooth;
    }

    @Override
    public String toString() {
        return "  Computer{cpu='" + cpu + "', gpu='" + gpu + "', ram=" + ram +
               "GB, storage=" + storage + "GB, wifi=" + wifi + ", bluetooth=" + bluetooth + "}";
    }

    public static class ComputerBuilder {
        private final String cpu;
        private String gpu = "Integrated";
        private int ram = 4;
        private int storage = 256;
        private boolean wifi = false;
        private boolean bluetooth = false;

        public ComputerBuilder(String cpu) { this.cpu = cpu; }

        public ComputerBuilder setGpu(String gpu) { this.gpu = gpu; return this; }
        public ComputerBuilder setRam(int ram) { this.ram = ram; return this; }
        public ComputerBuilder setStorage(int storage) { this.storage = storage; return this; }
        public ComputerBuilder setWifi(boolean wifi) { this.wifi = wifi; return this; }
        public ComputerBuilder setBluetooth(boolean bluetooth) { this.bluetooth = bluetooth; return this; }

        public Computer build() { return new Computer(this); }
    }
}
