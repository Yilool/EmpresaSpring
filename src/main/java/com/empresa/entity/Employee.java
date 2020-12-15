package com.empresa.entity;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee implements Comparable<Employee>, Serializable{
	private static AtomicInteger id = new AtomicInteger(0);
	private int empId;
	private String empName;
	private String empSurname;
	
	public Employee() {
		this.empId = id.addAndGet(1);
	}
	
	public Employee(String name, String surname) {
		this.empName = name;
		this.empSurname = surname;
		this.empId = id.addAndGet(1);
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSurname() {
		return empSurname;
	}

	public void setEmpSurname(String empSurname) {
		this.empSurname = empSurname;
	}

	public int getEmpId() {
		return empId;
	}

	@Override
	public int compareTo(Employee other) {
		return Integer.valueOf(this.empId).compareTo(other.getEmpId());
	}
}
