package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> findAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM produk";
        try (Connection c = Database.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Product p = mapRow(rs);
                list.add(p);
            }
        }
        return list;
    }

    private Product mapRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nama = rs.getString("nama");
        double harga = rs.getDouble("harga");
        int stok = rs.getInt("stok");
        String kat = rs.getString("kategori");
        if ("ELEKTRONIK".equals(kat)) {
            return new Electronics(id, nama, harga, stok);
        } else {
            return new Clothing(id, nama, harga, stok);
        }
    }

    // TODO: add create/update/delete as needed
}
