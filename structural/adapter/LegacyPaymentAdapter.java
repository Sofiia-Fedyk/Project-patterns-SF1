package structural.adapter;

// Adapter wraps the legacy system and translates calls to the new interface
public class LegacyPaymentAdapter implements PaymentProcessor {
    private final LegacyPaymentSystem legacySystem;

    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void processPayment(String currency, double amount) {
        // New interface: (currency, amount) → old interface: (amount, currencyCode)
        legacySystem.makePayment(amount, currency);
    }
}
