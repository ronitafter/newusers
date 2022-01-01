package com.sapir.service;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapir.beans.Customer;
import com.sapir.beans.CustomerList;
import com.sapir.beans.Order;
import com.sapir.exceptions.CustomerExceptions;
import com.sapir.repositories.CustomersRepository;
import com.sapir.repositories.OrdersRepository;

@Service
@Transactional
public class StoreService {

	private CustomersRepository customersRepository;
	private OrdersRepository ordersRepository;

//	___________________ Constructor ___________________ 
	@Autowired
	public StoreService(CustomersRepository customersRepository, OrdersRepository ordersRepository) {
		this.customersRepository = customersRepository;
		this.ordersRepository = ordersRepository;
	}

//	___________________ addCustomer ___________________ 
	public Long addCustomer(Customer customer) {
		return customersRepository.save(customer).getId();
	}

//	___________________ updateCustomer ___________________ 
	public void updateCustomer(Customer customer) throws CustomerExceptions {
		if (!(customer.getId() > 0 && customersRepository.existsById(customer.getId()))) {
			throw new CustomerExceptions("updateUser faild - user does not exist");
		} else {
//			customersRepository.save(customer);
			Customer customerFromDb = this.getCustomerById(customer.getId());
			customerFromDb.setAge(customer.getAge());
			customerFromDb.setFirstName(customer.getFirstName());
		}
	}

//	___________________ updateOrder ___________________ 
	public void updateOrder(Order order) throws CustomerExceptions {
		if (!(order.getId() > 0 && ordersRepository.existsById(order.getId()))) {
			throw new CustomerExceptions("order faild - order does not exist");
		} else {
			Order orderFromDb = this.getOrderById(order.getId());
			orderFromDb.setInfo(order.getInfo());
			orderFromDb.setOrderDate(order.getOrderDate());
		}
	}

//	___________________ deleteCustomer ___________________ 
	public void deleteCustomer(long id) throws CustomerExceptions {
		if (customersRepository.existsById(id)) {
			customersRepository.deleteById(id);
		} else {
			throw new CustomerExceptions("deleteCustomer failed - user does not exist");
		}
	}

// ___________________ getAllCustomersByAge ___________________ 
	public List<Customer> getAllCustomersByAge(int age) {
		return customersRepository.findByAge(age);
	}

//	___________________ getAllCustomers ___________________ 
	public List<Customer> getAllCustomers() {
		return customersRepository.findAll();
	}

//	___________________ getCustomerById ___________________ 
	public Customer getCustomerById(long id) {
		return customersRepository.findById(id).orElse(null);
	}

// ___________________ getCustomersByAgeFirstName ___________________ 
	public List<Customer> getCustomersByAgeFirstName(int age, String firstName) {
		return customersRepository.findByAgeAndFirstName(age, firstName);
	}
	
// ___________________ getCustomersByFirstName ___________________ 
		public  List<Customer> getCustomersFirstName(String firstName) {
			return customersRepository.findByFirstName(firstName);
		}

//	___________________ getOrderById ___________________ 
	public Order getOrderById(long id) {
		return ordersRepository.findById(id).orElse(null);
	}

//	___________________ getAllOrders ___________________ 
	public List<Order> getAllOrders() {
		return ordersRepository.findAll();
	}

//	___________________ getOrdersBetween ___________________ 
	public List<Order> getOrdersBetween(Date start, Date end) {
		return ordersRepository.findByOrderDateBetween(start, end);
	}

	// get all orders by customer id
	public List<Order> getCustomerOrders(long customerId) {
		Customer customer = this.getCustomerById(customerId);
		return customer.getOrders();
	}
}
