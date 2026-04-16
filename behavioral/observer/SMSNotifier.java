package behavioral.observer;

public class SMSNotifier implements Observer {

    private final String phone;

    public SMSNotifier(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String eventType, String data) {
        System.out.println("  SMS to " + phone + " [" + eventType + "]: " + data);
    }
}
