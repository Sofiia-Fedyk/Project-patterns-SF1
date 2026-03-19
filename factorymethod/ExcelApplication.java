package creational.factorymethod;

public class ExcelApplication extends Application {
    @Override
    protected Document createDocument() { return new ExcelDocument(); }
}
