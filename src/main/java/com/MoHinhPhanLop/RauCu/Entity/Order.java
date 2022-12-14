package com.MoHinhPhanLop.RauCu.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "`order`")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Double amount;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="order_id",referencedColumnName = "id")
	private Set<OrderDetail> orderDetails;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
