package com.kishore.jdbc;

import java.sql.*;
public class SavePointEx
{
public static void main(String[] args) throws Exception
{
	Connection con=null;
	try
	{
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		con.setAutoCommit(false);
		Statement st=con.createStatement();
		st.executeUpdate("insert into employee values(111,’raj’,8000,’dsnr’)");
		Savepoint sp=con.setSavepoint();
		st.executeUpdate("insert into employee values(222,’samuel’,7000,’koti’) ");
		con.rollback(sp);
		st.executeUpdate("insert into employee values(333,’tom’,9000,’abids’)");
		con.commit();
	}
	catch(Exception e)
	{
		con.rollback();
		System.out.println(e);
	}
}
}
