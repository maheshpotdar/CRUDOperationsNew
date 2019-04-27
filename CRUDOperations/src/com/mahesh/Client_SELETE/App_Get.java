package com.mahesh.Client_SELETE;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Get {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		// get la eagar loading manatat ani get matala ki query fire hote.

		Employee employee = session.get(Employee.class, 100);
		// select * from employee where id=1

		// jar 100 id takala tar db madhe 100 id cha record nahi so db madhun null
		// milato ani employee la null set karato
		// nullPointerException yeto.

		System.out.println("Employee Details\n");
		System.out.println("Id: " + employee.getId());
		System.out.println("Name: " + employee.getEname());
		System.out.println("Address: " + employee.getAddress());

		System.out.println("fetch successfully.");
	}
}
