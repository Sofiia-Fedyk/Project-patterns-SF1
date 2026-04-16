package behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Subject — manages subscriptions and notifies observers
public class EventManager {

    private final Map<String, List<Observer>> listeners = new HashMap<>();

    public void subscribe(String eventType, Observer observer) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(observer);
    }

    public void unsubscribe(String eventType, Observer observer) {
        List<Observer> users = listeners.get(eventType);
        if (users != null) {
            users.remove(observer);
        }
    }

    public void notify(String eventType, String data) {
        List<Observer> users = listeners.getOrDefault(eventType, List.of());
        for (Observer observer : users) {
            observer.update(eventType, data);
        }
    }
}
