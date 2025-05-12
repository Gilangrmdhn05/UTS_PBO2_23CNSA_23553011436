package payment;

public interface PaymentMethod {
    void pay(double amount);

    public String getName();
}
