package creational.factorymethod;

public class WordApplication extends Application {
    @Override
    protected Document createDocument() { return new WordDocument(); }
}
