package com.timelineplanner.TimeLineMapper.DAO;

import java.util.List;
import java.util.Optional;

import com.timelineplanner.TimeLineMapper.model.User;

public interface UserDao {

	public List<User> findAll();
	Optional<User> findById(String id);
	public User save(User timeline);
	public void deleteById(String id);
}
