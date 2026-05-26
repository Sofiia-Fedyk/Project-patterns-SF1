package functionalrevisited.executearound;

import java.util.function.Consumer;

public class FileManager {
    private FileManager() {
        System.out.println("Opening file");
    }

    private void close() {
        System.out.println("Closing file");
    }

    public static void use(Consumer<FileManager> block) {
        FileManager fm = new FileManager();
        try {
            block.accept(fm);
        } finally {
            fm.close();
        }
    }

    public FileManager read() {
        System.out.println("Reading");
        return this;
    }

    public FileManager write() {
        System.out.println("Writing");
        return this;
    }
}
