package com.wiley.db;

public class TestEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("com.wiley.db.Employee");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
