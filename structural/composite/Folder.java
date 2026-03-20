package structural.composite;

import java.util.ArrayList;
import java.util.List;

// Composite node — can contain both Files and other Folders
public class Folder implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) { this.name = name; }

    public void add(FileSystemComponent component) { children.add(component); }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Folder: " + name + " (" + getSize() + " KB)");
        for (FileSystemComponent child : children) {
            child.display(indent + "  ");
        }
    }

    @Override
    public long getSize() {
        return children.stream().mapToLong(FileSystemComponent::getSize).sum();
    }
}
