package payment;

public class EWalletPayment implements PaymentMethod {
    private String walletName;

    public EWalletPayment(String walletName) {
        this.walletName = walletName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Membayar Rp" + amount + " melalui e-wallet " + walletName);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
