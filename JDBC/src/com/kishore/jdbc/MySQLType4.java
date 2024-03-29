package com.kishore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class MySQLType4 {
public static void main(String args[]) {

	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is loaded");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		System.out.println("Connection created");
		String s = "insert into student(sno,name) values (?,?)";
		PreparedStatement ps = c.prepareStatement(s);
		ps.setInt(1, 101);
		ps.setString(2, "ram");
		ps.execute();
		c.close();
		System.out.println("Inserted");
		} 
	catch (Exception e) {
		System.out.println("Exception : " + e);
	}
	
}
}