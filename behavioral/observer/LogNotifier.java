package behavioral.observer;

public class LogNotifier implements Observer {

    @Override
    public void update(String eventType, String data) {
        System.out.println("  LOG [" + eventType + "]: " + data);
    }
}
