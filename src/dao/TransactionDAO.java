package dao;

import model.*;
import java.sql.*;

public class TransactionDAO {
    public void save(Transaction t) throws SQLException {
        String sqlTrx = "INSERT INTO transaksi(total, metode_pembayaran) VALUES (?,?)";
        try (Connection c = Database.getConnection(); PreparedStatement ps = c.prepareStatement(sqlTrx, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, t.getTotal());
            ps.setString(2, t.getStatus());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int trxId = keys.getInt(1);
                t.setId(trxId);
                for (DetailTransaction d : t.getItems()) {
                    saveDetail(trxId, d, c);
                }
            }
        }
    }

    private void saveDetail(int trxId, DetailTransaction d, Connection c) throws SQLException {
        String sqlDtl = "INSERT INTO detail_transaksi(transaksi_id, produk_id, jumlah) VALUES (?,?,?)";
        try (PreparedStatement ps = c.prepareStatement(sqlDtl)) {
            ps.setInt(1, trxId);
            ps.setInt(2, d.getProduct().getId());
            ps.setInt(3, d.getQuantity());
            ps.executeUpdate();
        }
    }
}