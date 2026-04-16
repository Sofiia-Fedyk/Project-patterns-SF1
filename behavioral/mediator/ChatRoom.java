package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

// Concrete mediator — coordinates communication between users
public class ChatRoom implements ChatMediator {

    private final List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            // Do not deliver the message back to the sender
            if (user != sender) {
                user.receive(message, sender.getName());
            }
        }
    }
}
