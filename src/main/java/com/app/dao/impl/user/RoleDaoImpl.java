package com.app.dao.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.user.RoleDao;
import com.app.model.Role;
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	HibernateResult hibernate;

	@Override
	public Role savePermissionDao(Role permission) {
		hibernate.getSession().save(permission);
		return permission;
	}

	@Override
	public List<Role> listRole() {
		List<Role> roles = hibernate.getResultList(Role.class);
		return roles;
	}

	@Override
	public Role getRoleById(int roleId) {
		Role role = hibernate.getById(Role.class, roleId);
		return role;
	}

}
