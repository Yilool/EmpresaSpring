package com.empresa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Comparable<Customer>, Serializable{
	private int cusId;
	private String cusName;
	private String cusSurname;
	private List<Product> cusProducts;
	
	public Customer() {
		this.cusProducts = new ArrayList<>();
	}
	
	public Customer(String name, String surname) {
		this.cusName = name;
		this.cusSurname = surname;
		this.cusProducts = new ArrayList<>();
	}
	
	public void addCusProduct(Product p) {
		cusProducts.add(p);
	}
	
	public void rmCusProduct(Product p) {
		cusProducts.remove(p);
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusSurname() {
		return cusSurname;
	}

	public void setCusSurname(String cusSurname) {
		this.cusSurname = cusSurname;
	}

	public int getCusId() {
		return cusId;
	}

	public ArrayList<Product> getCusProducts() {
		ArrayList<Product> aux = new ArrayList<>();
		
		aux.addAll(cusProducts);
		
		return aux;
	}

	@Override
	public int compareTo(Customer other) {
		return Integer.valueOf(this.cusId).compareTo(other.getCusId());
	}
}
