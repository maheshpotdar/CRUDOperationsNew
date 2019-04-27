package com.mahesh.Client_INSERT;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_SAVE_INSERT {

	public static void main(String[] args) {

		// hibernate madhe table manaje class.

		Employee employee = new Employee();
		employee.setEname("Sachin Tendulkar");
		employee.setAddress("Mumbai");

		Employee employee2 = new Employee();
		employee2.setEname("Virendra Sehwag");
		employee2.setAddress("Delhi");

		Employee employee3 = new Employee();
		employee3.setEname("Gautam Gambhir");
		employee3.setAddress("Delhi");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		// crud
		// Insert 3 ways ne karu shakato.
		// 1.save ==> primary key return karato.
		// 2.saveOrupdate ==> void
		// 3.persist ==> void

		int pk1 = (int) session.save(employee); // query lihila
		int pk2 = (int) session.save(employee2); // query lihila
		int pk3 = (int) session.save(employee3); // query lihila

		System.out.println("Primary key first: " + pk1);
		System.out.println("Primary key second: " + pk2);
		System.out.println("Primary key third: " + pk3);

		// operation perform kar.
		session.getTransaction().commit();

		session.evict(employee);
		session.evict(employee2);
		session.evict(employee3);

		System.out.println("Inserted successfully.");

	}
}
