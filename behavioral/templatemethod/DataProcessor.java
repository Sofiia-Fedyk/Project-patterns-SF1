package behavioral.templatemethod;

// Abstract class that defines the template method (algorithm skeleton)
public abstract class DataProcessor {

    // Template method — fixed sequence of steps
    public final void process(String rawData) {
        String parsed   = parse(rawData);
        String validated = validate(parsed);
        String result   = transform(validated);
        save(result);
    }

    protected abstract String parse(String rawData);

    protected abstract String validate(String data);

    protected String transform(String data) {
        return data.toUpperCase();
    }

    private void save(String result) {
        System.out.println("  Saved: " + result);
    }
}
