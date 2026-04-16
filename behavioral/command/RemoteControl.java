package behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

// Invoker — stores and executes commands, supports undo
public class RemoteControl {

    private final Deque<Command> history = new ArrayDeque<>();

    public void press(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            System.out.print("  [undo] -> ");
            last.undo();
        }
    }
}
