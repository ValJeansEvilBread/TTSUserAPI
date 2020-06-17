package com.tts.UsersAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.UsersAPI.model.User;
import com.tts.UsersAPI.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	 @GetMapping("/users")
	    public List<User> getUsers(){
	        return (List<User>) userRepository.findAll();
	 }
	 
	 @GetMapping("/users/{id}")
	    public Optional<User> getUserById(@PathVariable(value="id") Long id){
	        return userRepository.findById(id);
	    }
	 
	 @PostMapping("/users")
		public void createUser(@RequestBody User user){
		    userRepository.save(user);
		    System.out.println(user);
		}
	 
	  @PutMapping("/users/{id}")
		public void createUser(@PathVariable(value="id") Long id, @RequestBody User user){
		    userRepository.save(user);
		}
	  
	  @DeleteMapping("/users/{id}")
		public void createUser(@PathVariable(value="id") Long id){
		    userRepository.deleteById(id);
	  }
	  
	  
	  /* Code from final step of assignment causes code to crash.  Unable to troubleshoot. 
	 
	  @GetMapping("/users")
		public List<User> getUsers(@RequestParam(value="state", required=false) String state){
	        if (state != null) {
	            return (List<User>) userRepository.findByState(state);
	        }
	        return (List<User>) userRepository.findAll();
		}
		
		*/


}
