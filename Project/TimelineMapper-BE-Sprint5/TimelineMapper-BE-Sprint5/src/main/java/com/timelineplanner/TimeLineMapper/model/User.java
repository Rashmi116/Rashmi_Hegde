package com.timelineplanner.TimeLineMapper.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String id;
	

	@Column
	private String fname;

	@Column
	private String lname;

//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private List<TimeLine> timelines;

	
	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname +  "]";
	}

//	public List<TimeLine> getTimelines() {
//		return timelines;
//	}
//
//	public void setTimelines(List<TimeLine> timelines) {
//		this.timelines = timelines;
//	}

	public User() {
		super();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return fname.equals(user.fname)&&lname.equals(user.lname)&&id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fname,lname);
	}

}
