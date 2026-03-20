package creational.factory;

class Truck implements Transport {
    @Override
    public void deliver() { System.out.println("  Delivering by land in a truck"); }
}

class Ship implements Transport {
    @Override
    public void deliver() { System.out.println("  Delivering by sea in a ship"); }
}

class Airplane implements Transport {
    @Override
    public void deliver() { System.out.println("  Delivering by air in an airplane"); }
}

public class TransportFactory {
    public static Transport createTransport(String type) {
        switch (type.toLowerCase()) {
            case "truck":    return new Truck();
            case "ship":     return new Ship();
            case "airplane": return new Airplane();
            default: throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }
}
