package model;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // ── Encapsulation: getters & setters (no public fields) ──
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    // ── Polymorphism: overridden by subclasses ──
    public abstract double calculateDiscount();

    public double getPriceAfterDiscount() {
        return price - (price * calculateDiscount());
    }

    @Override
    public String toString() {
        return String.format("[#%d] %s (Rp%.2f, Stok: %d)", id, name, price, stock);
    }
}
