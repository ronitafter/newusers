package com.sapir;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sapir.beans.Customer;
import com.sapir.beans.Order;
import com.sapir.service.StoreService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class StoreApp {
// __________________________SERVER  __________________________________________
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApp.class);
//		initCustomers(context.getBean(StoreService.class));
		ControllerTester tester = context.getBean(ControllerTester.class);
		tester.testApi();
//	}

//	public static void initCustomers(StoreService storeService) {
//		List<Order> danaOrders = new ArrayList<Order>();
//		danaOrders.add(new Order("cardigan", Date.valueOf("2021-10-10")));
//		danaOrders.add(new Order("sweater", Date.valueOf("2021-10-13")));
//		
//		Customer dana = new Customer("dana", 30, danaOrders);
//		storeService.addCustomer(dana);	
//		List<Order> annaOrders = new ArrayList<Order>();
//		annaOrders.add(new Order("coat", Date.valueOf("2021-10-12")));
//		annaOrders.add(new Order("scarf", Date.valueOf("2021-10-16")));		Customer anna = new Customer("anna", 25, annaOrders);
//		
//		storeService.addCustomer(anna);
	}
	
}
