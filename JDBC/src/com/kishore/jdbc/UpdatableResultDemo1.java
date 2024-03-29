package com.kishore.jdbc;

import java.sql.*;
public class UpdatableResultDemo1
{
	public static void main(String[] args)throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from employee");
		rs.absolute(1);
		double sal = rs.getDouble(3);
		System.out.println(sal);
		sal = sal +500;
		rs.updateDouble(3,sal);
		rs.updateRow();
		System.out.println(rs.getDouble(3));
	} 
}