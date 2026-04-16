package behavioral.mediator;

public class AdminUser extends User {

    public AdminUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println("  [ADMIN] " + name + " broadcasts: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message, String senderName) {
        System.out.println("  [ADMIN] " + name + " received from " + senderName + ": " + message);
    }
}
