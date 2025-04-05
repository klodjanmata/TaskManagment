package ProjectEntity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProjectMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
    }
}
