package com.sapir;

import java.net.URI;



import java.net.URISyntaxException;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sapir.beans.Customer;
import com.sapir.beans.CustomerList;
import com.sapir.beans.Order;

@Component
public class ControllerTester {
// __________________________ TESTER __________________________________________
//	public static void main(String[] args) throws URISyntaxException {

	@Autowired
		private RestTemplate restTemplate;
		public void testApi() {

//		
//********************** ADD CUSTOMER ********************************
//		   restTemplate = new RestTemplate();
//			List<Order>AAAOrders = new ArrayList<Order>();
//			AAAOrders.add(new Order("cardigan8", Date.valueOf("2021-10-10")));
//			AAAOrders.add(new Order("sweater8", Date.valueOf("2021-10-13")));
//			Customer customer = new Customer("AAS", 20, AAAOrders);
//			System.out.println(customer);
//		ResponseEntity<Long> response = restTemplate.postForEntity(String.format("http://localhost:8080/customer"), customer,Long.class);
//		System.out.println("response statuse: " + response.getStatusCodeValue() );
//		System.out.println("response body: " + response.getBody());
//		System.out.println(customer);
//********************** GET CUSTOMER BY ID ********************************
//		resttemplate = new RestTemplate();
//		Customer customer = resttemplate.getForObject("http://localhost:8080/customer/1", Customer.class);
//		System.out.println(customer);

// ********************** GET CUSTOMERS BY NAME **********************
//				
//Customer customer = restTemplate.getForObject("http://localhost:8080/customer/ByFirstName?firstName=Rona", Customer.class);
//	customer);
	CustomerList customers = restTemplate.getForObject("http://localhost:8080/customer/ByFirstName?firstName=Rona", CustomerList.class);	
//	System.out.println(String.format("received customers: %s", customers.getCustomers()));
	System.out.println(customers.getCustomers());
//	customers.getCustomers().forEach(customer ->System.out.println (customer));

//	
	
//********************** UPDATE CUSTOMER ********************************
//		Customer customer = new Customer(1,"Daniella", 30);
//		customer.setAge(555);
//		customer.setFirstName("DDD");
//		resttemplate.put("http://localhost:8080/customer", customer);
//		System.out.println(customer);
//********************** GET ALL CUSTOMER ORDERS ********************************
		// 1. Wrapper class
		// 2. list using ParameterizedTypeReference and exchange method
		// 3. array
//		ResponseEntity<Order[]> res = resttemplate.getForEntity("http://localhost:8080/customer/orders/1",Order[].class);
//		Order[] arr = res.getBody();
//		List<Order> list = new ArrayList<>(Arrays.asList(arr));
//		System.out.println(list);
		
//********************** GET ALL CUSTOMERS ********************************
// WORKIN
//		CustomerList customers = resttemplate.getForObject(String.format("http://localhost:8080/customer"),
//				CustomerList.class);
//		System.out.println(String.format("received customers: %s", customers.getCustomers()));
// NOT WORKING
//	Customer[] customersArr = resttemplate.getForObject(String.format("http://localhost:8080/customer"), Customer[].class);
//		System.out.println(customersArr);
//********************** DELETE CUSTOMER ********************************	
//		System.out.println("checking method DeleteCustomer");
//	    resttemplate.delete("http://localhost:8080/customer/2");
//		System.out.println("customer deleted");
		
		
//	CustomersList customers = restTemplate.getForObject("http://localhost:8080/customer/ByFirstName?firstName=ranDanker", CustomersList.class);	
//	System.out.println(String.format("received customers: %s", customers.getCustomers()));
//    customers.getCustomers().forEach(customer -> System.out.println(customer));
//********************** ADD ORDER ********************************
		
//		?????
		
//********************** UPDATE ORDER ********************************

//????
				
// ********************** getAllUsersByAgeAndName **********************

//???
//********************** getAllCustomerByAge **********************
		// NOT WORKING
//	CustomerList customers = resttemplate.getForObject("http://localhost:8080/customer/ByAge?age=25", CustomerList.class);
//	System.out.println(String.format("received customers: %s", customers.getCustomers()));
//	System.err.println(customers.getCustomers());

//********************** GET ALL ORDERS ********************************
//		ResponseEntity<Order[]> res = resttemplate.getForEntity("http://localhost:8080/orders",Order[].class);
//		Order[] arr = res.getBody();
//		List<Order> list = new ArrayList<>(Arrays.asList(arr));
//		System.out.println(list);
//	
//			
//********************** ? ********************************	
//		List list = resttemplate.getForObject("http://localhost:8080/orders", List.class);
//		System.out.println(list);
//		Object orderAsMap =  list.get(0);
//		System.out.println(orderAsMap.getClass());

//		RequestEntity<?> req = new RequestEntity<>(HttpMethod.GET, new URI("http://localhost:8080/orders"));		
//		ParameterizedTypeReference<List<Order>> listOfOrder = new ParameterizedTypeReference<List<Order>>() {
//		};

//		List<Order> list2 = resttemplate.exchange(req, listOfOrder).getBody();
//		System.out.println(list2);
//		Order order = list2.get(0);		
				
// __________________________________ get the new customer __________________________________ 
//		
//		System.out.println("getting the new customer");
//		System.out.println(String.format("GET %s/customer/%d",SERVER_URL,response.getBody()));
////		Customer newCustomer = resttemplate.getForObject(String.format("%s/customer/%d", SERVER_URL,response.getBody()), Customer.class);
//		Customer newCustomer = resttemplate.getForObject("http://localhost:8080/customer/1", Customer.class);
//		System.out.println(String.format("new customer: %s", newCustomer.toString()));
//		System.out.println(newCustomer);

//	}
		

		}
	}

