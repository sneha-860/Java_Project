package dao;

import java.sql.*;

public class CartDAO {

    public boolean addToCart(int userId, int productId, int quantity) {
        boolean status = false;

        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO Cart(UserID, ProductID, Quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}