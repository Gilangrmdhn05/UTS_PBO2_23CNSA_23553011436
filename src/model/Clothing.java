package model;

public class Clothing extends Product {

    public Clothing(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    @Override
    public double calculateDiscount() {
        // Misalnya: diskon pakaian 20%
        return 0.20;
    }
}