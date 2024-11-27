package com.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;
import com.shop.services.CategoryService;
import com.shop.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService ps;

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository pr;

	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository cr;

	@Autowired
	private CategoryService cs;

	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {

		ps.addProduct(product);
		return "ok";

	}

	@GetMapping("/allProducts")
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageble = PageRequest.of(page, size);
		return ps.getAllProdutucts(pageble);
	}

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable Long id) {
		return ps.getProductById(id);
	}

	@PutMapping("/update/Products/{id}")
	public String updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		Product product3 = ps.getProductById(id);

		product3.setName(product.getName());
		product3.setPrice(product.getPrice());
		System.out.println(product3);
		return ps.addProduct(product3);

	}

	@DeleteMapping("/delete/products/{di}")
	public String deleteProductById(@PathVariable("di") Long id) {

		return ps.deleteProductById(id);
	}

}
