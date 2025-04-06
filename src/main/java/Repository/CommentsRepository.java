package Repository;

import Entity.Comments;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CommentsRepository {

    public void save(Comments comments) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(comments);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void delete(Comments comments) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(comments);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(Comments comments) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(comments);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Comments getCommentById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Comments.class, id);
        }
    }

    public List<Comments> seeAllComments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //return session.createQuery("from Movie").list();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Comments> cq = cb.createQuery(Comments.class);
            Root<Comments> root = cq.from(Comments.class);
            cq.select(root); // <- correct way
            return session.createQuery(cq).getResultList();
        }
    }
}

