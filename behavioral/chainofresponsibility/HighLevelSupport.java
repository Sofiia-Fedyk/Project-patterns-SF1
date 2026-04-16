package behavioral.chainofresponsibility;

// Handles critical (level 3) requests
public class HighLevelSupport extends AbstractHandler {

    @Override
    public String handle(int level, String request) {
        if (level == 3) {
            return "  HighLevelSupport resolved: " + request;
        }
        return super.handle(level, request);
    }
}
