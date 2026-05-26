package functionalrevisited.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class TextTransformer {
    private final Function<String, String> transform;

    @SafeVarargs
    public TextTransformer(Function<String, String>... transforms) {
        this.transform = Stream.of(transforms)
                .reduce(Function.identity(), Function::andThen);
    }

    public String apply(String input) {
        return transform.apply(input);
    }
}
