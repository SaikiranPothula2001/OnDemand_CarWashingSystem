package com.cg.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.security.entities.Role;
import com.cg.security.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role addRole(Role role) {
		return roleRepository.insert(role);
	}

	public Role updateRole(Role role) throws Exception {
		Optional<Role> op = roleRepository.findById(role.getId());
		if (op.isPresent()) {
			Role user1 = op.get();
			roleRepository.save(role);
			return role;
		} else {
			throw new Exception();
		}
	}

	public List<Role> getAllRoles() {

		return roleRepository.findAll();
	}

	public Role getRoleById(String id) throws Exception {
		Optional<Role> op = roleRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new Exception();
		}

	}

	public void deleteRole(String id) {
		Optional<Role> op = roleRepository.findById(id);
		if (op.isPresent()) {
			roleRepository.delete(op.get());
		}

	}

}

