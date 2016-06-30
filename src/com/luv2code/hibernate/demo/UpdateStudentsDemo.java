package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.util.HibernateUtil;

public class UpdateStudentsDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory created using HibernateUtil...");
		
		// create session from factory
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// build query and execute: get student record with firstName as 'Jon'
			List<Student> students = session.createQuery("from Student s where s.firstName = 'Jon'").list();
			
			Student studentRecord = students.get(0);
			
			int studentId = studentRecord.getId();
			
			Student myStudent = session.get(Student.class, studentId);
			
			// update the record
			myStudent.setLastName("Targeyreyan");
			
			// update email for all students
			// session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
						
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
