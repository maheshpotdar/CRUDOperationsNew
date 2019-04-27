package com.mahesh.Client_INSERT;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Persist_INSERT {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setEname("Ram Tendulkar");
		employee.setAddress("Satara");

		Employee employee2 = new Employee();
		employee2.setEname("Ganesh wadkar");
		employee2.setAddress("Aurangabad");

		Employee employee3 = new Employee();
		employee3.setEname("Jignesh Patel");
		employee3.setAddress("Gujrat");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr=session.beginTransaction();

		session.persist(employee);
		session.persist(employee2);
		session.persist(employee3);

		session.getTransaction().commit();

		System.out.println("Inserted successfully.");
	}
}
