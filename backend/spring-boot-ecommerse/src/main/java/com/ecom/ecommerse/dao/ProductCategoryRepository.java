package com.ecom.ecommerse.dao;

import com.ecom.ecommerse.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// name , path
@RepositoryRestResource(collectionResourceRel = "productCategory",path="product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
