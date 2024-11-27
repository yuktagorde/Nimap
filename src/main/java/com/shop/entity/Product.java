package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductId;

	private String name;

	private int price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("products")
	private Category category;

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(String name, int price, Category category) {
		super();

		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Product() {
		super();

	}

	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", name=" + name + ", price=" + price + ", category="
				+ category.getCategoryId() + "]";
	}

}
