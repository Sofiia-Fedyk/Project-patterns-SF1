package behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

// Caretaker — manages the history of mementos
public class History {

    private final Deque<EditorMemento> stack = new ArrayDeque<>();

    public void push(EditorMemento memento) {
        stack.push(memento);
    }

    public EditorMemento pop() {
        return stack.isEmpty() ? null : stack.pop();
    }
}
