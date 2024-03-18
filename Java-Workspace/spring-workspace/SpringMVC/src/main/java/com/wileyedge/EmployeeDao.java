package com.wileyedge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.Employee;

@Repository(value="dao")

public class EmployeeDao implements IDao {
	@Autowired
	private JdbcTemplate template;
	
	//@Autowired
	//private PlatformTransactionManager transactionManager;
	
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveEmployee(Employee e) {
		//System.out.println("inside Dao layer");
		String sql = "insert into employee1 (id,fname,lname) values(?,?,?)";
		template.update(sql,e.getEid(),e.getFname(),e.getLname());

	}

	public void modifyEmployee(Employee e) {
		
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String sql="select * from Employee1";
		return template.query(sql,
				//new EmployeeRowMapper());
				new BeanPropertyRowMapper<Employee>(Employee.class));
		
	}

	public Employee getEmployeeById(int empid) {
		String sql="select * from Employee1 where id=?";
		return template.queryForObject(sql,new Object[]{empid},
				//new EmployeeRowMapper());
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public String getEmployeeNameById(int empid) {
		// TODO Auto-generated method stub
		String sql="select fname from Employee1 where id=?";
		return template.queryForObject(sql, String.class,empid);
	}

	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from Employee1";
		int res = template.queryForObject(sql, Integer.class);
		return res;
	}

}
