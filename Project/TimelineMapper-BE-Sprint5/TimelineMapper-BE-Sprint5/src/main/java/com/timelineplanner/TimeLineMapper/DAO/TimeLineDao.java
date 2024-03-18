package com.timelineplanner.TimeLineMapper.DAO;

import java.util.List;
import java.util.Optional;

import com.timelineplanner.TimeLineMapper.model.TimeLine;

public interface TimeLineDao {
	public List<TimeLine> findAll();
	Optional<TimeLine> findById(int id);
	public TimeLine save(TimeLine timeline);
	public void deleteById(int id);
	public List<TimeLine> findByUserId(String userId);
}
