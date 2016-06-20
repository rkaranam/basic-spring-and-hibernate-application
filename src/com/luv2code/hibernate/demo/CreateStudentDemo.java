package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session from factory
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("Creating new student object.. ");
			Student student = new Student("Jon", "Snow", "jonsnow@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving the student object.. ");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done: Saved the student object!");
			
		} catch(Exception exc) {
			
		} finally {
			factory.close();
		}
		
	}

}
