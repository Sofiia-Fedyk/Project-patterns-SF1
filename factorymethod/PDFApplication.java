package creational.factorymethod;

public class PDFApplication extends Application {
    @Override
    protected Document createDocument() { return new PDFDocument(); }
}
