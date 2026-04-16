package behavioral.memento;

// Memento — stores a snapshot of the editor's state
public class EditorMemento {

    private final String content;

    EditorMemento(String content) {
        this.content = content;
    }

    String getContent() {
        return content;
    }
}
