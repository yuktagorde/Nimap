package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.shop.entity.Category;
import com.shop.services.CategoryService;
import com.shop.services.ProductService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cs;

	@Autowired
	private ProductService ps;

	@PostMapping("/addData")
	public Category addC(@RequestBody Category category) {
		return cs.addCategory(category);
	}

	@GetMapping("/allCategories")
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageble = PageRequest.of(page, size);
		return cs.getAllCategories(pageble);
	}

	@GetMapping("/getById/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return cs.getCategoryById(id);
	}

	@PutMapping("/update/categories/{id}")
	public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
		Category category1 = cs.getCategoryById(id);

		category1.setCategoryName(category.getCategoryName());

		return cs.addCategory(category1);
	}

	@DeleteMapping("/delete/categories/{di}")
	public String deleteCategoryById(@PathVariable("di") Long id) {

		return cs.deleteCategoryById(id);
	}

}
