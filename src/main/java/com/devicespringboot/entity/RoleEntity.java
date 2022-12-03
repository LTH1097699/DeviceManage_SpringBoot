package com.devicespringboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "role")
public class RoleEntity extends AbstractEntity {
	@Column(name = "code")
	private String roleCode;

	@Column(name = "name")
	private String roleName;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<AccountEntity> accounts;

}
