package behavioral.observer;

public class EmailNotifier implements Observer {

    private final String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, String data) {
        System.out.println("  Email to " + email + " [" + eventType + "]: " + data);
    }
}
