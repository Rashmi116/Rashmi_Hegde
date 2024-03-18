package com.timelineplanner.TimeLineMapper.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.timelineplanner.TimeLineMapper.model.TimeLine;

@Repository
public interface TimeLineJPARepository extends JpaRepository<TimeLine, Integer>, TimeLineDao {
//	@Query("SELECT t FROM TimeLine t WHERE t.userId = ?1") 
	public List<TimeLine> findByUserId(String userId);
}