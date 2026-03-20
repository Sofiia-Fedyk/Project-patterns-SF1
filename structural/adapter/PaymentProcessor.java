package structural.adapter;

// New standard interface expected by the application
public interface PaymentProcessor {
    void processPayment(String currency, double amount);
}
