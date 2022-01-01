package com.sapir.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.StackTraceElementDeserializer;
import com.sapir.beans.Customer;
import com.sapir.beans.CustomerList;
import com.sapir.beans.Order;
import com.sapir.exceptions.CustomerExceptions;
import com.sapir.service.StoreService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private StoreService storeService;

	@Autowired
	public CustomerController(StoreService storeService) {
		this.storeService = storeService;
	}

//------------------- getAllCustomers -------------------------------
	@GetMapping
	public CustomerList getAllCustomers() {
		return new CustomerList(storeService.getAllCustomers());
	}

//	@GetMapping("/all")
//	public Customer[] getAllCustomers2() {
//		return storeService.getAllCustomers().toArray(new Customer[0]);
//	}

//------------------- getCustomerById -------------------------------
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(storeService.getCustomerById(id), HttpStatus.OK);
	}

//		Customer customer = storeService.getCustomer(id);
//		try {
//			return new ResponseEntity<>(customer, HttpStatus.OK);		
//		} catch (Exception e) {
//			//CustomerExceptions
//			ResponseDto responsdto = new ResponseDto(false, e.getMessage());
//			return new ResponseEntity<>(responsdto, HttpStatus.NOT_FOUND);
//		}
//------------------- addCustomer -------------------------------
	@PostMapping
	// public Long addCustomer(@RequestBody Customer customer) {
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		Long id = storeService.addCustomer(customer);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}
//		try {
//			storeService.addCustomer(customer);
//			// userService.save(user).getId();
//			ResponseDto responsdto = new ResponseDto(true, "customer added");
//			return new ResponseEntity<>(responsdto, HttpStatus.CREATED);
//		} catch (Exception e) {
//			InvalidOperationException
//			ResponseDto responsdto = new ResponseDto(false, e.getMessage());
//		}

//------------------- updateCustomer -------------------------------

	@PutMapping
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws CustomerExceptions {
		storeService.updateCustomer(customer);
		return ResponseEntity.ok(customer);
//		ResponseDto responseDto = new ResponseDto(true, "updateCustomer successfully");
//		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
//		Map<String, Object> response = new HashMap<String, Object>();
//		response.put("success", true);
//		response.put("message", "customer updateUser successfully");
//		return new ResponseEntity<Map>(response, HttpStatus.OK);

	}

//------------------- deleteCustomer -------------------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) throws CustomerExceptions {

		try {
			storeService.deleteCustomer(id);
//			return ResponseEntity.ok().build();
			return new ResponseEntity<>("customer deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("customer not found", HttpStatus.NOT_FOUND);
		}
	}
//		try {
//			return new ResponseEntity<>("user deleted", HttpStatus.OK);
//			//			return new ResponseEntity(HttpStatus.CREATED);
//
//		} catch (CustomerExceptions e) {
//			ResponseDto responsdto = new ResponseDto(false, e.getMessage());
//			return new ResponseEntity<ResponseDto>(responsdto, HttpStatus.OK);
//		}

//------------------- getAllCustomerByAgeQueryParam ----------------------
	@GetMapping("/ByAge")
	public List<Customer> getAllCustomerByAgeQueryParam(@RequestParam("age") Integer age) {
		return storeService.getAllCustomersByAge(age);
	}

	@GetMapping("/ByFirstName")
// ___________________ getCustomersByFirstName ___________________ 
			public CustomerList getCustomersByFirstName(@RequestParam("firstName")String firstName) {
			return new CustomerList(storeService.getCustomersFirstName(firstName));
	}
	
	
//------------------- getAllCustomerByAge -------------------------------
	@GetMapping("/ByAge/{age}")
	public List<Customer> getAllCustomerByAge(@PathVariable("age") Integer age) {
		return storeService.getAllCustomersByAge(age);
	}

//------------------- getAllUsersByAgeAndName -------------------------------
	@GetMapping("/ByAgeAndName")
	public List<Customer> getAllUsersByAgeAndName(@RequestParam("age") Integer age, @RequestParam("name") String name) {
		return storeService.getCustomersByAgeFirstName(age, name);
		}
	

//------------------- getCustomerOrders -------------------------------
	@GetMapping("/orders/{cutomerId}")
	public List<Order> getCustomerOrders(@PathVariable long cutomerId) {
		return storeService.getCustomerOrders(cutomerId);

	}

}
