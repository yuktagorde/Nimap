package com.shop.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;

@Service
public class ProductService implements ProductRepository {

	@Autowired
	private ProductRepository ProductRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService CategoryService;

	public Product findByName(String name) {
		return ProductRepository.findByName(name);
	}

	public Page<Product> getAllProdutucts(Pageable pageble) {
		return ProductRepository.findAll(pageble);
	}

	public Product getProductById(Long Id) {
		return ProductRepository.findById(Id).orElseThrow(() -> new RuntimeException("Product not found"));

	}

	public String addProduct(@RequestBody Product product) {

		Category category = product.getCategory();
		Optional<Category> category1 = categoryRepository.findByCategoryName(category.getCategoryName());
		Category category2 = new Category();
		String name = product.getName();
		Product product1 = new Product();
		product1.setCategory(category);
		if (category1.isEmpty()) {
			// product1.setCategory(category2).getCategoryName();
			category2.setCategoryName(category.getCategoryName());
			categoryRepository.save(category2);
		} else {
			category2 = category1.get();
		}

		if (product.getName().isEmpty()) {
			return "null";
		}
		product1.setProductId(product.getProductId());
		product1.setName(name);
		product1.setPrice(product.getPrice());
		product1.setCategory(category2);

		System.out.println(product1);
		ProductRepository.save(product1);

		return "ok";

	}

	public String deleteProductById(Long id) {
		ProductRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));

		ProductRepository.deleteById(id);

		return "deleted successful";
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Product> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
