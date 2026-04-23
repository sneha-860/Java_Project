import dao.*;
import beans.*;
import java.util.*;

public class TestDAO {

    public static void main(String[] args) {

        // 🔹 Test User Registration
        UserDAO userDAO = new UserDAO();
        UserBean user = new UserBean();
        user.setName("Sneha");
        user.setEmail("sneha@gmail.com");
        user.setPassword("123");

        boolean reg = userDAO.registerUser(user);
        System.out.println("User Registered: " + reg);

        // 🔹 Test Login
        UserBean loginUser = userDAO.loginUser("sneha@gmail.com", "123");
        System.out.println("Login Success: " + (loginUser != null));

        // 🔹 Test Product Fetch
        ProductDAO productDAO = new ProductDAO();
        List<ProductBean> products = productDAO.getAllProducts();

        for (ProductBean p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        // 🔹 Test Order
        OrderDAO orderDAO = new OrderDAO();
        OrderBean order = new OrderBean();
        order.setUserID(1);

        boolean orderPlaced = orderDAO.placeOrder(order);
        System.out.println("Order Placed: " + orderPlaced);
    }
}