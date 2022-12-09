package com.MoHinhPhanLop.RauCu.Entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String image;
	
	private String name;
	
	private Double price;
	
	@ManyToOne 
    @JoinColumn(name = "category_id")
    private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> orderDetail;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategories() {
		return category;
	}

	public void setCategories(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Product(String image, String name, Double price, Category category) {
		this.image = image;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public Product() {
	}
}
