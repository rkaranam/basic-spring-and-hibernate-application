package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentsDemo {

	@SuppressWarnings("unchecked")
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

			// build query and execute: List out all the student records in db
			List<Student> studentsList = session.createQuery("from Student").list();
			displayStudents(studentsList);
			
			// build query and execute: List out all student records whose last_name is 'Stark'
			List<Student> starkStudents = session.createQuery("from Student s where s.lastName = 'Stark'").list();
			displayStudents(starkStudents);
			
			// build query and execute: List out both Starks and Snows
			List<Student> starksAndSnows = 
					session.createQuery("from Student s where s.lastName = 'Stark'" 
							+ "OR s.lastName='Snow'").list();
			displayStudents(starksAndSnows);
			
			// build query and execute: List records whose email id like '%@luv2code.com'
			List<Student> likeMailStudents = session
					.createQuery("from Student s where s.email LIKE '%@luv2code.com'").list();
			displayStudents(likeMailStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		
		System.out.println("Records retrieved: " + students.size());
		
		// display the retrieved records
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
