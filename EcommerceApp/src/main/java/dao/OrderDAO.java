package dao;

import beans.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO {

    public void placeOrder(Order order) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(order);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}