package com.kishore.jdbc;

import java.util.*;
import java.sql.*;
public class UpdateRecord
{
	public static void main(String[] args)throws Exception
	{
		DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
		Connection con =DriverManager.getConnection("jdbc:odbc:ksreddyDSN","scott","tiger");
		Statement st = con.createStatement();
		Scanner s= new Scanner(System.in);
		System.out.println("enter employee number");
		int empno=s.nextInt();
		int updateCount = st.executeUpdate("update employee set esal =esal+5000 where eno="+empno);
		System.out.println("records updated"+updateCount);
		st.close();
		con.close();
	}
}