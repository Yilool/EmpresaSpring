package com.empresa.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Comparable<Employee>, Serializable{

	private int empId;
	private String empName;
	private String empSurname;
	private ArrayList<Product> empProducts;
	
	public Employee() {
		this.empProducts = new ArrayList<>();
	}
	
	public Employee(String name, String surname) {
		this.empName = name;
		this.empSurname = surname;
		this.empProducts = new ArrayList<>();
	}
	
	public void addEmpProduct(Product p) {
		empProducts.add(p);
	}
	
	public void rmEmpProduct(Product p) {
		empProducts.remove(p);
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

	public ArrayList<Product> getEmpProducts() {
		ArrayList<Product> aux = new ArrayList<>();
		
		aux.addAll(empProducts);
		
		return aux;
	}

	@Override
	public int compareTo(Employee other) {
		return Integer.valueOf(this.empId).compareTo(other.getEmpId());
	}
}
