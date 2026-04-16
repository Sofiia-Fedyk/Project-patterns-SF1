package behavioral.templatemethod;

public class JSONProcessor extends DataProcessor {

    @Override
    protected String parse(String rawData) {
        // Minimal JSON unwrapping for demo
        String parsed = rawData.replaceAll("[{}\":]", "").trim();
        System.out.println("  JSON parsed:   " + parsed);
        return parsed;
    }

    @Override
    protected String validate(String data) {
        if (data.isBlank()) throw new IllegalArgumentException("JSON data is empty");
        System.out.println("  JSON validated: OK");
        return data;
    }
}
