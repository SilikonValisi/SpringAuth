package com.loginProject.withMongo.Register;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/test")
	public String testing() {
		return "TEST FOR PROJECT";
	}
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public void registerUser(@RequestBody Userr newUser) {
		userService.registerUser(newUser);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/profile")
	public Userr getUserByUsername(@RequestBody LoginUser user) {
		return userService.getUserByUsername(user.getUsername() );
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public Userr isExist(@RequestBody LoginUser loginUser) {
		return userService.isExist(loginUser);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET,value="/all")
	public List<Userr>  getUsers() {
		return userService.getUsers();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/update")
	public Userr updateUser(@RequestBody Userr updateUser) {
		return userService.updateUser(updateUser);
	}
	
}
