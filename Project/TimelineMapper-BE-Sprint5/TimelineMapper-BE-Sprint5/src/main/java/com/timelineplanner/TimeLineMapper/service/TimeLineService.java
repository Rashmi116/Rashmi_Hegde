package com.timelineplanner.TimeLineMapper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timelineplanner.TimeLineMapper.DAO.TimeLineDao;
import com.timelineplanner.TimeLineMapper.DAO.TimeLineJPARepository;
import com.timelineplanner.TimeLineMapper.DAO.UserDao;
import com.timelineplanner.TimeLineMapper.model.TimeLine;
import com.timelineplanner.TimeLineMapper.model.User;

@Service
public class TimeLineService implements TimeLineServiceInterface {
	
	@Autowired
	private TimeLineDao dao;
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public List<TimeLine> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<TimeLine> findById(int id) {
		return dao.findById(id);
	}

	@Override
	public TimeLine save(TimeLine timeline) {
		return dao.save(timeline);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		return;
	}

	@Override
	public List<User> findAllUsers() {
		return userdao.findAll();
	}

	@Override
	public Optional<User> findUserById(String id) {
		return userdao.findById(id);
	}

	@Override
	public User save(User user) {
		return userdao.save(user);
	}

	@Override
	public void deleteById(String id) {
		userdao.deleteById(id);
		return;		
	}

	@Override
	public List<TimeLine> userById(String id) {
		return dao.findByUserId(id);
	}

}
