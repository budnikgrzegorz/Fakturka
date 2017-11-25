package pl.sdacademy.hibernateannotations;

import org.hibernate.Session;
import sample.SessionFactoryManager;

public class HibernateDao<T> {
    private Session session;
    private Class<T> clazz;

    public HibernateDao(Class clazz) {
        this.clazz = clazz;
    }

    // Metoda otwierającą sesję (potrzebujemy obiektu reprezentującego połączenie, aby wykonać operację na bazie)
    public void openSession() {
        session = SessionFactoryManager.getSessionFactory().openSession();
        // Rozpoczniemy transakcję, w ramach której będziemy wykonywać operacje.
        session.beginTransaction();
    }

    public void closeSessionWithCommit() {
        session.getTransaction().commit();
        session.close();
    }

    public void closeSessionWithRollback() {
        session.getTransaction().rollback();
        session.close();
    }

    public void add(T entity) {
        session.save(entity);
    }

    public void update(T entity) {
        session.update(entity);
    }

    public T get(int id) {
        return session.get(clazz, id);
    }

    public void delete(int id) {
        T entity = session.get(clazz, id);
        session.delete(entity);
    }
}
