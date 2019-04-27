package com.mahesh.Client_SELETE;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Load {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();

		// load la lazy loading manatat. karan jo parenta (non-primary key) cha data
		// fetch hota nahi toparent query fire hota nahi.

		Employee employee = session.load(Employee.class, 1000); // query fire nahiiiiii
		// 1000 id cha object nahi pan query fire hota nahi non-pk query fire mag check
		// data(Object) present or not
		// so id 10000 print honar.pan name veli error yenar.
		System.out.println("Employee Details\n");
		System.out.println("Id: " + employee.getId()); // primary key //query fire nahiiiiii
		System.out.println("Name: " + employee.getEname()); // (non-primary key) query Fire zali.e.g.select * from
															// employee where id=1
		// problem particular column milat nahi manaje fakt name pahije nahi milnar.
		// criteria-projections madhun milato.

		System.out.println("Address: " + employee.getAddress());

		System.out.println("fetch successfully.");
	}
}
