package dao;

import beans.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

    public void saveUser(User user) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(user);

            tx.commit();

            System.out.println("User inserted successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}