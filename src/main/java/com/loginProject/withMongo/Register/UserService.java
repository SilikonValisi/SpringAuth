package com.loginProject.withMongo.Register;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public void registerUser(Userr newUser) {
		userRepository.save(newUser);
	}
	
	public Userr getUserByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public List<Userr> getUsers() {
		List<Userr> userList = new ArrayList<>();
		userRepository.findAll().forEach(pivotUser -> {
			userList.add(pivotUser);
		});
		return userList;
	}
	
	public Userr isExist(LoginUser loginUser) {
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();
		Userr theUser = userRepository.findByUsername(username);
//		System.out.println(theUser);
//		System.out.println(theUser.getPassword());
//		System.out.println(theUser.getUsername());
//		System.out.println(theUser !=null && theUser.getPassword().equals(password));
		if(theUser !=null && theUser.getPassword().equals(password)) {		
			return theUser;
		}
		else {
			return null;
		}
	}
	
	public void deleteUser(String id){
		userRepository.deleteById(id);
	}
	public Userr updateUser(Userr updateUser){
		System.out.println(updateUser);
		return userRepository.save(updateUser);
		
	}
}
