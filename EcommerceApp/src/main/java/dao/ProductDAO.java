package dao;

import beans.ProductBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

    public void saveProduct(ProductBean product) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(product);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    public List<ProductBean> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ProductBean", ProductBean.class).list();
        }
    }
}