package com.ecom.ecommerse.dao;

import com.ecom.ecommerse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
