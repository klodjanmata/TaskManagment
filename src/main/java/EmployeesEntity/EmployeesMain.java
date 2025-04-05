package EmployeesEntity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeesMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .buildSessionFactory();
    }
}
