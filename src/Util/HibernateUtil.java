/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import Entity.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Abdo
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Entity.BoardDecisions.class);
            configuration.addAnnotatedClass(Entity.ActualGrades.class);
            configuration.addAnnotatedClass(Entity.ClassStudents.class);
            configuration.addAnnotatedClass(Entity.Classes.class);
            configuration.addAnnotatedClass(Entity.Contacts.class);
            configuration.addAnnotatedClass(Entity.EmployeeAttendance.class);
            configuration.addAnnotatedClass(Entity.FinalGrades.class);
            configuration.addAnnotatedClass(Entity.GradeDetail.class);
            configuration.addAnnotatedClass(Entity.LectureDatetime.class);
            configuration.addAnnotatedClass(Entity.Payroll.class);
            configuration.addAnnotatedClass(Entity.Persons.class);
            configuration.addAnnotatedClass(Entity.SGLog.class);
            configuration.addAnnotatedClass(Entity.Schedule.class);
            configuration.addAnnotatedClass(Entity.SchoolExpenses.class);
            configuration.addAnnotatedClass(Entity.Staff.class);
            configuration.addAnnotatedClass(Entity.StaffClasses.class);
            configuration.addAnnotatedClass(Entity.Student.class);
            configuration.addAnnotatedClass(Entity.StudentAttendance.class);
            configuration.addAnnotatedClass(Entity.StudentExpenses.class);
            configuration.addAnnotatedClass(Entity.StudentNotes.class);
            configuration.addAnnotatedClass(Entity.StudyYears.class);
            configuration.addAnnotatedClass(Entity.Subjects.class);
            configuration.addAnnotatedClass(Entity.Teacher.class);
            configuration.addAnnotatedClass(Entity.TeacherSubjects.class);
            configuration.addAnnotatedClass(Entity.UserLog.class);
            configuration.addAnnotatedClass(Entity.Users.class);
            System.out.println("Hibernate Configuration loaded");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
