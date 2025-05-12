package app;

import dao.ProductDAO;
import dao.TransactionDAO;
import model.*;
import payment.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        TransactionDAO tdao = new TransactionDAO();
        Scanner sc = new Scanner(System.in);

        try {
            List<Product> products = pdao.findAll();
            System.out.println("=== Daftar Produk ===");
            products.forEach(System.out::println);

            Transaction trx = new Transaction();

            while (true) {
                System.out.print("Masukkan ID produk (0 untuk selesai): ");
                int id = sc.nextInt();
                if (id == 0) break;

                Product selected = products.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElse(null);

                if (selected != null) {
                    System.out.print("Jumlah: ");
                    int qty = sc.nextInt();
                    trx.addItem(selected, qty);
                }
            }

            System.out.printf("Total (setelah diskon): Rp%,.2f\n", trx.getTotal());


            System.out.println("Metode pembayaran (1=Credit Card, 2=Bank, 3=E-Wallet): ");
            int methodChoice = sc.nextInt();
            sc.nextLine(); // Konsumsi newline

            PaymentMethod method = null;
            switch (methodChoice) {
                case 1:
                    System.out.print("Masukkan nomor kartu: ");
                    String card = sc.nextLine();
                    method = new CreditCardPayment(card);
                    break;
                case 2:
                    System.out.print("Masukkan nama bank: ");
                    String bank = sc.nextLine();
                    method = new BankTransferPayment(bank);
                    break;
                case 3:
                    System.out.print("Masukkan nama e-wallet: ");
                    String wallet = sc.nextLine();
                    method = new EWalletPayment(wallet);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            // Tetapkan metode pembayaran & proses transaksi
            trx.setPaymentMethod(method);

            if (method != null) {
                trx.checkout();
                tdao.save(trx); // Simpan ke DB
                System.out.println("Transaksi berhasil disimpan.");
            } else {
                System.out.println("Transaksi dibatalkan karena metode pembayaran tidak valid.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
