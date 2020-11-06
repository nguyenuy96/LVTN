package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;

	private String name;

	private String gender;

	private String phoneNumber;

	private String nationality;

	private String identification;

	private String address;

	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;
}
