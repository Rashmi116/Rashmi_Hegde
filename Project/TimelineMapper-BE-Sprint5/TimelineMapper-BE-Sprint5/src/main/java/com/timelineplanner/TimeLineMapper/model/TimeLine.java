package com.timelineplanner.TimeLineMapper.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


enum State{
	
	STARTED,PENDING,FINISHED
}

@Entity
public class TimeLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;	
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private String description; // Agenda or tasks
	private String report;
	private LocalDateTime timestamp=LocalDateTime.now();
	private State state=State.STARTED; 
	 
	private String userId;
	
//	@ManyToOne
//	@JoinColumn(name="userId")
//	private User user;	
	
	
	public TimeLine() {
		super();
	}
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "TimeLine [id=" + id + ", title=" + title + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", description=" + description + ", report=" + report + ", timestamp=" + timestamp + ", state="
				+ state +  "]";
	}


	public LocalDateTime getStart_time() {
		return start_time;
	}


	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}


	public LocalDateTime getEnd_time() {
		return end_time;
	}


	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReport() {
		return report;
	}
	
	public void setReport(String report) {
		this.report = report;
	}
	
//	
//	public User getUser() {
//		return user;
//	}
//	
//	public void setUser(User user) {
//		this.user = user;
//	}	

}
