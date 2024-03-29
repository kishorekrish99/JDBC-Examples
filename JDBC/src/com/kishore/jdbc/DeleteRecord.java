package com.kishore.jdbc;

import java.sql.*;
public class DeleteRecord
{
	public static void main(String[] args)throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:ksreddyDSN","scott","tiger");
		Statement st = con.createStatement();
		int updateCount = st.executeUpdate("delete from employee where esal<=1000");
		System.out.println("records deleted: "+updateCount);
		st.close();
		con.close();
	}
}