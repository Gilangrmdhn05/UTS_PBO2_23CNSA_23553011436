package model;

import payment.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int id;
    private List<DetailTransaction> items = new ArrayList<>();
    private PaymentMethod paymentMethod;

    public void addItem(Product p, int qty) {
        items.add(new DetailTransaction(p, qty));
    }

    public double getTotal() {
        return items.stream().mapToDouble(DetailTransaction::getSubtotal).sum();
    }

    public void checkout() {
        if (paymentMethod == null) {
            throw new IllegalStateException("Metode pembayaran belum ditentukan!");
        }

        double total = getTotal();
        paymentMethod.pay(total);
    }

    public void checkout(PaymentMethod method) {
        this.paymentMethod = method;
        checkout(); // panggil versi tanpa parameter
    }

    public List<DetailTransaction> getItems() {
        return items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    private String status;

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

}
