package structural.composite;

// Common interface for both leaf (File) and composite (Folder) nodes
public interface FileSystemComponent {
    void display(String indent);
    long getSize();
}
