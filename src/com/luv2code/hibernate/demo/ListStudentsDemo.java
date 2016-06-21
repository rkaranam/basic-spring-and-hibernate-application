package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ListStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session from factory
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// construct a query
			Query queryResult = session.createQuery("from Student");
			
			System.out.println("Query Result: " + queryResult);
			
			List<?> studentsFromQuery = queryResult.list();
			
			System.out.println("Retrieving students from database.. ");
			for(Object student: studentsFromQuery) {
				System.out.println(student);
			}
			
			// retrieve all student objects from the database
			List<?> students = session.createCriteria(Student.class).list();
			
			System.out.println("\nStudents: " + students);
			
			System.out.println("Retrieving students from database.. ");
			for(Object student: students) {
				System.out.println(student);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
