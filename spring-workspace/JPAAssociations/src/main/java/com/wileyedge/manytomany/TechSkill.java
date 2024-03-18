package com.wileyedge.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="tech3")
public class TechSkill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column()
	private String skill;
	@ManyToMany(targetEntity = Employee.class)
	private List<Employee> employees;

	public TechSkill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechSkill(String skill) {
		super();
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

}
