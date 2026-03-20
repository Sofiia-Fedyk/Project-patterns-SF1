package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Factory caches TreeType objects so identical types are never created twice
public class TreeFactory {
    private static final Map<String, TreeType> cache = new HashMap<>();

    public static TreeType getTreeType(String name, String color) {
        String key = name + "_" + color;
        if (!cache.containsKey(key)) {
            cache.put(key, new TreeType(name, color));
            System.out.println("  [Flyweight] Created new TreeType: " + name + " (" + color + ")");
        }
        return cache.get(key);
    }

    public static int getCachedCount() { return cache.size(); }
}
