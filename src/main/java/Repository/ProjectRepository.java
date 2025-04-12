package Repository;

import Entity.Employees;
import Entity.Project;
import Entity.Task;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class ProjectRepository {

    public void save(Project project ) {
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
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Project> cq = cb.createQuery(Project.class);
            Root<Project> root = cq.from(Project.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        }

    }


    public Project findById(int id) {
            Project project = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                project = session.get(Project.class, id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return project;
        }


    public Project getProjectid(int projectId) {
            Transaction transaction = null;
            Project project = null;

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                project = session.get(Project.class, projectId);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }

        return project;

    }


}