package com.app.dao;

import java.util.List;
import java.util.Optional;

import com.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);
}
