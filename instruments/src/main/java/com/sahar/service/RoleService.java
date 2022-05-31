package com.sahar.service;

import java.util.List;

import com.sahar.entities.Role;





public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}

