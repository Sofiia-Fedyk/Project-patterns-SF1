package behavioral.mediator;

// Colleague — communicates only through the mediator
public abstract class User {

    protected final ChatMediator mediator;
    protected final String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message, String senderName);

    public String getName() {
        return name;
    }
}
