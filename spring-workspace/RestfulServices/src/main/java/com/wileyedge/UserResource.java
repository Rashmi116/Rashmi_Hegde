package com.wileyedge;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private IService service;
	
	//@RequestMapping(value = "/users",method = RequestMethod.GET)
	@GetMapping(path="/users")
	public List<User> retriveAllUsers(){
		System.out.println("Inside retriveAllUsers() of userResource ");
		return service.findAll();		
	}
	
	//@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	@GetMapping(path="/users/{id}")
	public User retriveUser(@PathVariable int id) {
		System.out.println("Inside retriveAllUsers() of userResource "+id);
		Optional<User> opt= service.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			System.out.println("throwing exception");
			throw new UserNotFoundException("id = "+id+" not found");
		}
	}
	
	@PostMapping(path="/users",consumes ="application/json" )
	public String createUser(@Valid @RequestBody User user,BindingResult result,Model model) throws MethodArgumentNotValidException {
		System.out.println("inside createuser() of userResource");
		if(result.hasErrors()) {
			System.out.println("validation error occurred");
			throw new MethodArgumentNotValidException(null, result);
		}
		service.save(user);
		return "added";
		
	}
	
	@DeleteMapping(path="/users/{id}")
	public String deleteUser(@PathVariable int id) {
		System.out.println("inside deleteuser of userresource");
		service.deleteById(id);
		return "deleted";
	}
	@GetMapping(path = "/users/name/{name}")
	public List<User> retriveUserByName(@PathVariable String name){
		System.out.println("Inside retriveUserByName() of UserResource");
		List<User> users =  service.findByName(name);
		if(users==null) {
			throw new UserNotFoundException(name+ " not found");
		}
		return users;
	}
	

}