package dao;

import beans.UserBean;
import java.sql.*;

public class UserDAO {

    public boolean registerUser(UserBean user) {
        boolean status = false;

        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO Users(Name, Email, Password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public UserBean loginUser(String email, String password) {
        UserBean user = null;

        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM Users WHERE Email=? AND Password=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserBean();
                user.setUserID(rs.getInt("UserID"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}