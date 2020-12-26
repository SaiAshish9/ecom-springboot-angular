package com.ecom.ecommerse.dao;

import com.ecom.ecommerse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
