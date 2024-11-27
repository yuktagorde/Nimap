package com.shop.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.entity.Category;
import com.shop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);

	@Query("SELECT c FROM Product c")
	Page<Product> getAllProdutucts(Pageable pageble);

	// public Product addProduct(Product product);

}
