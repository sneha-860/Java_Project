package dao;

import beans.ProductBean;
import java.sql.*;
import java.util.*;

public class ProductDAO {

    public List<ProductBean> getAllProducts() {
        List<ProductBean> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM Products";
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductBean p = new ProductBean();
                p.setProductID(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setPrice(rs.getDouble("Price"));
                p.setStock(rs.getInt("Stock"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}