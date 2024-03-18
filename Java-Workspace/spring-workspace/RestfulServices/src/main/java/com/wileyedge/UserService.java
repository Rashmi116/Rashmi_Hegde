package com.wileyedge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IService {
	
	@Autowired
	//@Qualifier("memdao")
	@Qualifier("datajpadao")
	private IDao dao;

	@Override
	public List<User> findAll() {
		System.out.println("inside findall");
		
		
		return dao.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		System.out.println("inside findid of service");
		return dao.findById(id);
		
	}

	@Override
	public User save(User user) {
		System.out.println("inside save() of service");
		return dao.save(user);
		
	}

	@Override
	public User deleteById(int id) {
		System.out.println("inside deletebyiD() of service");
		return dao.deleteById(id);
	}
	public List<User> findByName(String name){
		System.out.println("Inside save() of UserService");
		return dao.findByName(name);
	}

}
