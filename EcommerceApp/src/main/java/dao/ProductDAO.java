package dao;

import beans.Product;
import org.hibernate.Session;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Product", Product.class).list();
        }
    }
}