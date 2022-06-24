package com.example.serveletdemo.Utils;

import java.util.Properties;

import com.example.serveletdemo.Models.Course;
import com.example.serveletdemo.Models.CourseAssignment;
import com.example.serveletdemo.Models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 * Java based configuration
 * @author Gasaro Leila
 *
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/java_web?characterEncoding=utf8&&serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop"); //set to update once you are stable
                //settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(CourseAssignment.class);
//                configuration.addAnnotatedClass(Bed.class);
//                configuration.addAnnotatedClass(Course.class);
//                configuration.addAnnotatedClass(CourseAssignment.class);
//                configuration.addAnnotatedClass(BedAssignment.class);
//                configuration.addAnnotatedClass(AuditTrail.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
