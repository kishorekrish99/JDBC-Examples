package com.kishore.jdbc;

import java.sql.*;
public class RetrieveRecords
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:ksreddyDSN","scott","tiger");
		Statement stmt = con.createStatement();
		
		ResultSet res = stmt.executeQuery("select * from employee");
		while(res.next()){
		System.out.println(res.getInt(1)+"\t" + res.getString(2) + "\t" + res.getDouble(3)+"\t"+res.getString(4));
		}
		res.close();
		stmt.close();
		con.close();
	}
}