package com.sapir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapir.beans.Order;
import com.sapir.exceptions.CustomerExceptions;
import com.sapir.service.StoreService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private StoreService service;
	
//------------------- getAllOrders -------------------------------
	@GetMapping
	public List<Order> getAllOrders(){
		return this.service.getAllOrders();
	}
	
//------------------- updateOrder -------------------------------
	@PutMapping
	public ResponseEntity<?> updateOrder(@RequestBody Order order){
		try {
			service.updateOrder(order);
			return ResponseEntity.ok(null);
		} catch (CustomerExceptions e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	

}
