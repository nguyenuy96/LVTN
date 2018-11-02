package com.app.dao.user;

import java.util.List;

import com.app.model.Role;

public interface RoleDao {
	Role savePermissionDao(Role permission);

	List<Role> listRole();

	Role getRoleById(int roleId);
}
