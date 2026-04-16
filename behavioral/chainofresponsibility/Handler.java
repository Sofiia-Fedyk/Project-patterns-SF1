package behavioral.chainofresponsibility;

public interface Handler {
    Handler setNext(Handler next);
    String handle(int level, String request);
}
