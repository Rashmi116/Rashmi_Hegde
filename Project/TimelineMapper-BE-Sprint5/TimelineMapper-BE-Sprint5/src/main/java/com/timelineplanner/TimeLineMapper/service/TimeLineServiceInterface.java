package com.timelineplanner.TimeLineMapper.service;

import java.util.List;
import java.util.Optional;

import com.timelineplanner.TimeLineMapper.model.TimeLine;
import com.timelineplanner.TimeLineMapper.model.User;

public interface TimeLineServiceInterface {
	
	public List<TimeLine> findAll();
	public List<TimeLine> userById(String id);
	Optional<TimeLine> findById(int id);
	public TimeLine save(TimeLine timeline);
	public void deleteById(int id);
	
	public List<User> findAllUsers();
	Optional<User> findUserById(String id);
	public User save(User timeline);
	public void deleteById(String id);
}
