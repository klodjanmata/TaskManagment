package Repository;

import Entity.Task;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TaskRepository {

    public void save(Task task) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(task);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Task task) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(task);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Task task) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(task);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Task.class, id);
        }
    }

    public List<Task> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Task> cq = cb.createQuery(Task.class);
            Root<Task> root = cq.from(Task.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        }
    }
}