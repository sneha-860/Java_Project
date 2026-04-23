package dao;

import beans.Cart;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CartDAO {

    public void addToCart(Cart cart) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(cart);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}