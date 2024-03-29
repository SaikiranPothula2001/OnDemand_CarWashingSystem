package com.cg.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.security.entities.Role;
import com.cg.security.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/add")
	public ResponseEntity<Object> addRole(@RequestBody Role role) {
		try {
			return ResponseEntity.ok().body(roleService.addRole(role));
		} catch (Exception e) {
			return new ResponseEntity<Object>("Cannot add role", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Role>> getAllRoles() {

		return ResponseEntity.ok().body(roleService.getAllRoles());
	}

	@GetMapping("list/{id}")
	public ResponseEntity<Object> getRoleById(@PathVariable String id) {
		try {
			return ResponseEntity.ok().body(roleService.getRoleById(id));
		} catch (Exception e) {
			return new ResponseEntity<Object>("Role not found with id" + id, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateRole(@PathVariable String id, @RequestBody Role role) {
		try {
			role.setId(id);
			return ResponseEntity.ok().body(roleService.updateRole(role));
		} catch (Exception e) {
			return new ResponseEntity<Object>("Role with id" + id + "does not exist", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRole(@PathVariable String id) {
		try {
			this.roleService.deleteRole(id);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Role not found :id " + id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

