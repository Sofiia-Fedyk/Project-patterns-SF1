package structural.composite;

// Leaf node — has no children
public class File implements FileSystemComponent {
    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + " KB)");
    }

    @Override
    public long getSize() { return size; }
}
