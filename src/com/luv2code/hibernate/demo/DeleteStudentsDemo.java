package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.util.HibernateUtil;

public class DeleteStudentsDemo {

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
			
			List<Student> studentsBeforeDeletion = session.createQuery("from Student").list();
			System.out.println("Students before deletion: ");
			displayStudents(studentsBeforeDeletion);
			
			// two ways of deleting object in hibernate
			// 1. Retrieve and Delete
			// 2. Delete on the way
			
			int studentId = 11;
			
			// first way
			/*Student studentToDelete = session.get(Student.class, studentId);			
			System.out.println("Retrieved record: " + studentToDelete);			
			System.out.println("Deleting record.. " + studentToDelete.getFirstName());			
			session.delete(studentToDelete);*/
			
			// second way
			session.createQuery("delete from Student where id = " + studentId).executeUpdate();
			
			List<Student> studentsAfterDeletion = session.createQuery("from Student").list();
			System.out.println("Students after deletion: ");
			displayStudents(studentsAfterDeletion);
						
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
