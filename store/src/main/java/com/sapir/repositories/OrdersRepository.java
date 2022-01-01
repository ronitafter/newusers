package com.sapir.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapir.beans.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
	List<Order> findByOrderDateBetween(Date low, Date high);
}
