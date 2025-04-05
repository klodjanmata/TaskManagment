package Repository;

import Entity.Employees;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeesRepository {
    public void save(Employees employees) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(employees);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Employees employees ) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(employees);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(Employees employees) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(employees);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Employees getEmployessById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Employees.class, id);
        }
    }

    public List<Employees> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employees> criteriaQuery = criteriaBuilder.createQuery(Employees.class);
            Root<Employees> root = criteriaQuery.from(Employees.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
