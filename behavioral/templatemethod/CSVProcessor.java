package behavioral.templatemethod;

public class CSVProcessor extends DataProcessor {

    @Override
    protected String parse(String rawData) {
        String parsed = rawData.replace(",", " | ");
        System.out.println("  CSV parsed:    " + parsed);
        return parsed;
    }

    @Override
    protected String validate(String data) {
        if (data.isBlank()) throw new IllegalArgumentException("CSV data is empty");
        System.out.println("  CSV validated: OK");
        return data;
    }
}
