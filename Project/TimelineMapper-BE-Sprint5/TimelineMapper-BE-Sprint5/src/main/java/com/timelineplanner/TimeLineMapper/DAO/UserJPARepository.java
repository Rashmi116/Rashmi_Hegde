package com.timelineplanner.TimeLineMapper.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timelineplanner.TimeLineMapper.model.User;

public interface UserJPARepository extends UserDao, JpaRepository<User, Integer> {
	
}
