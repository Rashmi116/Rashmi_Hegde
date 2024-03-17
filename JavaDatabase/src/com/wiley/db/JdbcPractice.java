package com.wiley.db;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcPractice {
	/*5 steps to connect java application using jdbc
	Register the Driver
	Create a Connection
	Create SQL Statement
	Execute SQL Statement
	Closing the connection*/
	/*3 Types of ResultSet in JDBC 2.0
	TYPE_FORWARD_ONLY: cursor moves to forward only.
	TYPE_SCROLL_INSENSITIVE: The result set generally does not show changes 
	        to the underlying database that are made while it is open
	TYPE_SCROLL_SENSITIVE
	        The result set is sensitive to changes made while it is open*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
		//	System.out.println(con);
			String sql = "CREATE TABLE BLOBDEMO1 (EMP_ID INT NOT NULL,PHOTO blob,PRIMARY KEY (EMP_ID)) ENGINE=INNODB";
			Statement s=con.createStatement();
			s.execute(sql);
			File file=new File("D:\\c376\\abc.txt");
			FileInputStream fis=new FileInputStream(file);
			String insert = "insert into blobdemo1(emp_id,photo) values (?, ?)";
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setInt(1,10);
			ps.setBinaryStream(2, fis, (int)file.length());
			//ps.executeUpdate();
			String select="select * from blobdemo1";
			Statement stat1 = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			ResultSet rs=stat1.executeQuery(select);
			while(rs.next()) {
				int id=rs.getInt("emp_id");
				Object pic=rs.getObject("photo");
				System.out.println(id+" "+pic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
