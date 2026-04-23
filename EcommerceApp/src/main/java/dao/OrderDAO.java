package dao;

import beans.OrderBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO {

    public void placeOrder(OrderBean order) {
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