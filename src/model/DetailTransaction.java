package model;

public class DetailTransaction {
    private Product product;
    private int quantity;

    public DetailTransaction(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getSubtotal() {
        return product.getPriceAfterDiscount() * quantity;
    }
}
