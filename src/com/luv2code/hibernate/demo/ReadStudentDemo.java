package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Sansa", "Stark", "sansa@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving the student object.. ");
			session.save(student);
			System.out.println("Object saved: " + student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// Reading the saved object
			// Get the generated id: primary key
			System.out.println("Generated Id: " + student.getId());
			
			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student based on id: primary key
			Student studentRetrieved = session.get(Student.class, student.getId());
			System.out.println("Student retrieved: " + studentRetrieved);
			
			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
