package com.mahesh.Client_INSERT;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table
public class Employee {

	@Id // for primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // auto_increment
	@Column(name = "id")
	private int id;

	@Column(name = "ename", length = 25)
	private String ename;

	@Column(name = "eaddress", length = 25)
	private String address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String ename, String address) {
		super();
		this.id = id;
		this.ename = ename;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", address=" + address + "]";
	}

}
