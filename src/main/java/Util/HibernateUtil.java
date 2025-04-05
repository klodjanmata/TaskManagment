package Util;
import Entity.Comments;
import Entity.Employees;
import Entity.Project;
import Entity.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    public static SessionFactory buildSessionFactory () {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employees.class)
                    .addAnnotatedClass(Comments.class)
                    .addAnnotatedClass(Project.class)
                    .addAnnotatedClass(Task.class)
                    .buildSessionFactory();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

}


