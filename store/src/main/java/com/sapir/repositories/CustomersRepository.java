package com.sapir.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapir.beans.Customer;
import com.sapir.beans.CustomerList;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByAgeAndFirstName(int age, String firstName);
	List<Customer>  findByFirstName(String firstName);
	List<Customer> findByAge(int age);

}
