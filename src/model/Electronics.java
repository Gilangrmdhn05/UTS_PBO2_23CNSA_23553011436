package model;

public class Electronics extends Product {

    public Electronics(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    @Override
    public double calculateDiscount() {
        // Misalnya: diskon elektronik 10%
        return 0.10;
    }
}