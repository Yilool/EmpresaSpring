package com.empresa.entity;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Comparable<Customer>, Serializable{
	private static AtomicInteger id = new AtomicInteger(0);
	private int cusId;
	private String cusName;
	private String cusSurname;
	
	public Customer() {
		this.cusId = id.addAndGet(1);
	}
	
	public Customer(String name, String surname) {
		this.cusName = name;
		this.cusSurname = surname;
		this.cusId = id.addAndGet(1);
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

	@Override
	public int compareTo(Customer other) {
		return Integer.valueOf(this.cusId).compareTo(other.getCusId());
	}
}
