package dao;

import beans.UserBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

    public void saveUser(UserBean user) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(user);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public UserBean getUser(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(UserBean.class, id);
        }
    }
}