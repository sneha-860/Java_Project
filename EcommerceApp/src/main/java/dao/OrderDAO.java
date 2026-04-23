package dao;

import beans.OrderBean;
import java.sql.*;
import java.util.*;

public class OrderDAO {

    public boolean placeOrder(OrderBean order) {
        boolean status = false;

        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO Orders(UserID, Date, Status) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, order.getUserID());
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setString(3, "Placed");

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}