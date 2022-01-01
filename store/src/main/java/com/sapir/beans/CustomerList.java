package com.sapir.beans;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {

	private List<Customer> customers = new ArrayList<>();

	public CustomerList() {
	}

	public CustomerList(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}