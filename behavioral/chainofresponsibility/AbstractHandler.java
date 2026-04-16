package behavioral.chainofresponsibility;

public abstract class AbstractHandler implements Handler {

    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public String handle(int level, String request) {
        if (next != null) {
            return next.handle(level, request);
        }
        return "  No handler could process: " + request;
    }
}
