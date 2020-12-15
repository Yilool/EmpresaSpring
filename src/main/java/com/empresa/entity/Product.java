package com.empresa.entity;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Product implements Comparable<Product>, Serializable{
	private static AtomicInteger id = new AtomicInteger(0);
	private int prdId;
	private String prdName;
	private double prdPrice;
	
	public Product() {
		this.prdId = id.addAndGet(1);
	}
	
	public Product(String name, double price) {
		this.prdName = name;
		this.prdPrice = price;
		this.prdId = id.addAndGet(1);
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public double getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(double prdPrice) {
		this.prdPrice = prdPrice;
	}

	public int getPrdId() {
		return prdId;
	}

	@Override
	public int compareTo(Product other) {
		return Integer.valueOf(this.getPrdId()).compareTo(other.getPrdId());
	}
}
