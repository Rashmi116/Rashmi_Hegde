package com.wileyedge;

import com.wileyedge.dao.EmployeeDao;
import com.wileyedge.dao.IDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDao dao=new EmployeeDao();
		dao.createEmployee(0, "Rashmi", "Hegde");
		dao.createEmployee(1, "Rashi", "Hegde");
		dao.updateEmployee(0, "Rani");
		dao.removeEmployee(0);


	}

}
