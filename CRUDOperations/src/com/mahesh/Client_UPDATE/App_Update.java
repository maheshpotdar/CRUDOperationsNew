package com.mahesh.Client_UPDATE;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Update {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(1);
		employee.setEname("John Cina");

		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setAddress("Uk");

		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setEname("Great Khali");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
//
//		session.update(employee);
//		session.update(employee2);
//		session.update(employee3);
//
//		session.getTransaction().commit();
//
//		System.out.println("update successfully.");
//	
		// ***************Problem in
		// Update**********************************************
		// samaja session madhe 1 id cha object ahe
		// ani mi session cha use karun 1 id cha update data update karayala gelo tar
		// uniqueObject Exception.

		session.get(Employee.class, 1);

		//update or merge kartana
		//---------Way-1-----------------------------------------------------------------
		//Employee employee = session.get(Employee.class, 1); // fire select query.
		//1 Mahesh Potdar save in session cache.
		//so you update same object 
		//1 db madhe ahe kay ahe 
		//Ramesh ahe kay nahi mahesh kad Ramesh
		//session cache potdar ahe potdar ahe kay ahe kahi karu nako.
		//o/p --> 1 Ramesh Potdar
		//---------Way-2-----------------------------------------------------------------
		//Employee employee = session.get(Employee.class, 1); // fire select query.
		//ani navin object tayar kela .
		//ata session chya cache madhe ahe.
		//ani navin object tayar kela .
		//Employee emp2=new Employee();
		//update Employee set name='Mahesh' where id=1;
		//id pahije
		//emp2.setId(1);
		//emp2.setName("Ram Dada");
		
		//navin object --> 1 Ram Dada
		//db madhe update /merge 
		//1 ahe kay ahe
		//Ram Dada ahe kay nahi Mahesh kad Ram dada ghal.
		//baki kahi user ne dilela nahiye. so null null null int tar 0
		
		
		Employee employee4 = new Employee();
		employee4.setId(1);
		employee4.setEname("Mamu jan");
		employee4.setAddress("Afrika");

		session.update(employee4);
		System.out.println("update successfully.");
	}
}
