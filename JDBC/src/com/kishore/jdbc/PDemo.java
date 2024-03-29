package com.kishore.jdbc;

import java.sql.*;
import java.util.*;
import java.io.*;
public class PDemo
{
public static void main(String rags[])
{
	try
	{
		Properties p= new Properties();
		p.load(new FileInputStream("db.properties"));
		
		String driver=p.getProperty("driver");
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String pass=p.getProperty("password");
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pass);
		Statement stmt=con.createStatement();
		System.out.println("statement object created");
		stmt.executeUpdate("create table student(sno number,sname varchar2(30),saddr varchar2(45))");
		System.out.println("table created");
		stmt.executeUpdate("insert into student values(101,’ram’,’dsnr’)");
		stmt.executeUpdate("insert into student values(102,’raj’,’koti’)");
		System.out.println("records inserted");
		//process the result
		
		ResultSet rs=stmt.executeQuery("select * from student");
		while(rs.next()==true)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
	catch(SQLException se)
	{
		System.out.println("database problems"+se);
	}
	catch(ClassNotFoundException ce)
	{
		System.out.println("class not available"+ce);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}