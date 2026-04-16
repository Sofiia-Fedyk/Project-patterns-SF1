package behavioral.chainofresponsibility;

// Handles medium (level 2) requests
public class MidLevelSupport extends AbstractHandler {

    @Override
    public String handle(int level, String request) {
        if (level == 2) {
            return "  MidLevelSupport resolved: " + request;
        }
        return super.handle(level, request);
    }
}
