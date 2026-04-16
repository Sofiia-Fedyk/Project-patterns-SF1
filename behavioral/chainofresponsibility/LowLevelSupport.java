package behavioral.chainofresponsibility;

// Handles simple (level 1) requests
public class LowLevelSupport extends AbstractHandler {

    @Override
    public String handle(int level, String request) {
        if (level == 1) {
            return "  LowLevelSupport resolved: " + request;
        }
        return super.handle(level, request);
    }
}
