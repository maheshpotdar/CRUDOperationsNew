package com.mahesh.Client_INSERT;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Persist_SaveOrUpdate {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(1);
		employee.setEname("Pranav Patil");

		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setEname("Akhilesh Wadkar");

		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setEname("Shyam Patel");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		session.saveOrUpdate(employee);
		session.saveOrUpdate(employee2);
		session.saveOrUpdate(employee3);

		session.getTransaction().commit();

		System.out.println("Inserted successfully.");
	}
}
