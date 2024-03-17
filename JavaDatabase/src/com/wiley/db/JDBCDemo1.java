package com.wiley.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCDemo1 {
	
	public static MysqlDataSource getDataSource() throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("empmgmt");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerTimezone("America/Chicago");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
		//Server Timezone helps the server know how to handle dates and times correctly.
		//Use SSL toggles SSL encryption. We would typically set this to true, but for our local development, 
		//it would be overkill to set up the infrastructure. We default to false for this activity.
		//Allow Public Key Retrieval allows our JDBC driver to send the password to our database securely.
		return ds;
	}
	
	public static void displayRecords() throws SQLException {
		String select="SELECT * FROM DEPT";
		Connection con=getDataSource().getConnection();
		System.out.println(con);
		Statement stat=con.createStatement();
		ResultSet s=stat.executeQuery(select);
		ResultSetMetaData rs=s.getMetaData();
		System.out.println(rs.getColumnName(1)+" "+rs.getColumnName(2)+" "+rs.getColumnName(3));
		while(s.next()) {
			int deptno=s.getInt(1);
			String deptname=s.getString(2);
			String loc=s.getString(3);
			System.out.println(deptno+" "+deptname+" "+loc);
		}
	}
	public static void insertRecords(int deptid,String dname,String loc) throws SQLException {
		Connection con=getDataSource().getConnection();
		System.out.println(con);
		Statement stat=con.createStatement();
		//String insert="insert into dept values(80,'tech','banglore')";
		PreparedStatement pstat =con.prepareStatement("INSERT INTO DEPT(DEPTID,DNAME,LOC) VALUES(?,?,?)");
		pstat.setInt(1, deptid);
		pstat.setString(2, dname);
		pstat.setString(3, loc);
		int n=pstat.executeUpdate();
		System.out.println("no of rows inserted are "+n);
		//boolean n1=pstat.execute();
		//System.out.println(" rows inserted? "+n1);
		
	}
	public static void updateRecords(int deptid,String loc) throws SQLException {
		Connection con=getDataSource().getConnection();
		System.out.println(con);
		Statement stat=con.createStatement();
		String update="UPDATE DEPT SET LOC=? WHERE DEPTID=?";
		PreparedStatement pstat =con.prepareStatement(update);
		pstat.setString(1,loc);
		pstat.setInt(2, deptid);
		boolean n=pstat.execute();
		System.out.println("no of rows updated ar "+n);
		
	}
	public static void deleteRecords(int deptid) throws SQLException {
		Connection con=getDataSource().getConnection();
		System.out.println(con);
		Statement stat=con.createStatement();
		String delete="delete from dept where deptid = ?";
		PreparedStatement pstat =con.prepareStatement(delete);
		pstat.setInt(1,deptid);
		int n=pstat.executeUpdate();
		System.out.println(" no of rows deleted "+n);
		
	}

	public static void main(String[] args) {
		
		try {
			//insertRecords(12,"abc","Mysore");
			//updateRecords(12,"Manglore");
			deleteRecords(12);
			displayRecords();
			
			//updateRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
