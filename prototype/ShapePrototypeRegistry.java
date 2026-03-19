package creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class ShapePrototypeRegistry {
    private final Map<String, Shape> prototypes = new HashMap<>();

    public void registerPrototype(String key, Shape shape) {
        prototypes.put(key, shape);
    }

    public Shape getShape(String key) {
        Shape prototype = prototypes.get(key);
        if (prototype == null) throw new IllegalArgumentException("No prototype for key: " + key);
        return prototype.clone();
    }

    public void displayRegistry() {
        System.out.println("  Registered prototypes:");
        prototypes.forEach((k, v) -> System.out.println("    " + k + " -> " + v));
    }
}
