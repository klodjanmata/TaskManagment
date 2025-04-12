package Repository;

import Entity.Project;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProjectRepository {

    public void save(Project project) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(project);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Project project) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(project);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Project project) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(project);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Project> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Project", Project.class).list(); // Fixed from "Person" to "Project"
        }
    }

    // Corrected method to fetch project by ID
    public Project Projectid(int projectId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Project.class, projectId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Project findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Project.class, id);
        }
    }
}

