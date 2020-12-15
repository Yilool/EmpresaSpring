package com.empresa.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Customer;
import com.empresa.entity.Employee;
import com.empresa.entity.Product;

@Service
public class AppService {
	private List<Customer> customers = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();


	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Customer existCustom(int id) {
		return getCustomers().stream().filter(c -> c.getCusId() == id).findFirst().orElse(null);
	}

	public Product existProduct(int id) {
		return getProducts().stream().filter(p -> p.getPrdId() == id).findFirst().orElse(null);
	}

	public Employee existEmployee(int id) {
		return getEmployees().stream().filter(e -> e.getEmpId() == id).findFirst().orElse(null);
	}

	//	public Product existEmpPrd(int prdId, int empId) {
	//		Product p1 = existProduct(prdId);
	//		Employee e1 = existEmployee(empId);
	//		
	//		return (e1 != null && p1 != null) ? e1.getEmpProducts().stream().filter(ep -> ep.getPrdId() == prdId).findFirst().orElse(null) : null;
	//	}
}
