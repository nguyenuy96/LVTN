package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order1")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	private String payment;

	private boolean isPay;

	private boolean isDelivery;

	private String addressDelivery;

	private String phoneDelivery;

	private String orderState;

	@OneToOne
	@JoinTable(name = "contact_id")
	private Contact contact;

	@OneToOne
	@JoinTable(name = "orders_in_cart", joinColumns = {
			@JoinColumn(name = "orderId", referencedColumnName = "orderId") }, inverseJoinColumns = {
					@JoinColumn(name = "cartId", referencedColumnName = "cartId") })
	private Cart cart;
}
