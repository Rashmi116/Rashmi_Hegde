package com.wiley.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		//step 1:load and register the jdbc driver(type 4)
		//2:get the Connection object by passing url,username,password
		//3.get the Statements from the Connection
		//4.get the ResultSet from the Statement
		//print the result
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//static block of driver is called and register
			System.out.println("type 4 driver of mysql is loaded into memory");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empmgmt?useSSL=false","root","root");
			System.out.println("connection is "+con);
			Statement stat=con.createStatement();
			String insert="insert into dept values(60,'tech','banglore')";
			//int n=stat.executeUpdate(insert);
			//System.out.println("no of rows inserted are "+n);
			//String select="SELECT * FROM DEPT";
			//ResultSet s=stat.executeQuery(select);
			/*while(s.next()) {
				int deptno=s.getInt(1);
				String deptname=s.getString(2);
				String loc=s.getString(3);
				System.out.println(deptno+" "+deptname+" "+loc);
			}*/
			/*String update="UPDATE DEPT SET LOC='CHENNAI'WHERE DEPTID=60";
			int n=stat.executeUpdate(update);
			System.out.println("no of rows updated are "+n);
			String select="SELECT * FROM DEPT";
			ResultSet s=stat.executeQuery(select);
			while(s.next()) {
				int deptno=s.getInt(1);
				String deptname=s.getString(2);
				String loc=s.getString(3);
				System.out.println(deptno+" "+deptname+" "+loc);
			}*/
			String delete="delete from dept where deptid = 60";
			int n=stat.executeUpdate(delete);
			System.out.println("no of rows updated are "+n);
			String select="SELECT * FROM DEPT";
			ResultSet s=stat.executeQuery(select);
			ResultSetMetaData rs=s.getMetaData();
			System.out.println(rs.getColumnName(1)+" "+rs.getColumnName(2)+" "+rs.getColumnName(3));
			while(s.next()) {
				int deptno=s.getInt(1);
				String deptname=s.getString(2);
				String loc=s.getString(3);
				System.out.println(deptno+" "+deptname+" "+loc);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("driver class is not found");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
