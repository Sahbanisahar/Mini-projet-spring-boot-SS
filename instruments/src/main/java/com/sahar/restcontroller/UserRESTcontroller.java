package com.sahar.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahar.entities.User;
import com.sahar.service.UserService;

@RestController
@RequestMapping("/apiuser")
@CrossOrigin
public class UserRESTcontroller {
	
	@Autowired
	UserService userService;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers()
	{
		return userService.findAll();
	}
	
	
	//@RequestMapping(method = RequestMethod.PUT)
	@RequestMapping(value="/{nom}/{role}",method = RequestMethod.PUT)
	public User changeUser(@PathVariable("nom") String nom, @PathVariable("role") String role ) {
		
	User abc= userService.addRoleToUser(nom,role);
	return userService.updateUser(abc);
	}

}
