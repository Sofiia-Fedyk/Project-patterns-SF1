package structural.adapter;

// Third-party legacy system with an incompatible method signature
public class LegacyPaymentSystem {
    public void makePayment(double amount, String currencyCode) {
        System.out.println("  [Legacy] Processing " + currencyCode + " " + String.format("%.2f", amount));
    }
}
