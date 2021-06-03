package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long roleId;

	@Column(nullable = false, unique = true)
	private String roleName;

	@Column
	private String searchName;

	@OneToOne
	@JoinColumn(name = "privilege_id", nullable = false)
	private Privilege privilege;
}
