package creational.factorymethod;

interface Document {
    void open();
    void save();
}

class PDFDocument implements Document {
    @Override
    public void open() { System.out.println("  Opening PDF document"); }
    @Override
    public void save() { System.out.println("  Saving PDF document"); }
}

class WordDocument implements Document {
    @Override
    public void open() { System.out.println("  Opening Word document"); }
    @Override
    public void save() { System.out.println("  Saving Word document"); }
}

class ExcelDocument implements Document {
    @Override
    public void open() { System.out.println("  Opening Excel document"); }
    @Override
    public void save() { System.out.println("  Saving Excel document"); }
}

public abstract class Application {
    protected abstract Document createDocument();

    public void newDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }
}
