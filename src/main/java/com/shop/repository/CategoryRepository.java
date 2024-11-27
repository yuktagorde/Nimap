package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	// List<Category> getAllCategories();

	@Query("SELECT c FROM Category c")
	Page<Category> getAllCategories(Pageable pageble);

	Optional<Category> findByCategoryName(String categoryName);

}
