package com.app.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@CreationTimestamp
	private OffsetDateTime createdDate;

	@UpdateTimestamp
	private OffsetDateTime updatedDate;

	@OneToMany(mappedBy = "cartDetailId.cart", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CartDetail> cartDetail = new HashSet<>();

	public Cart(Long cartId) {
		this.cartId = cartId;
	}
}
