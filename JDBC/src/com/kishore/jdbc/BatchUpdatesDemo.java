package com.kishore.jdbc;

import java.sql.*;
public class BatchUpdatesDemo
{
	public static void main(String args[]) throws Exception{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","system");
	con.setAutoCommit(false);
	st=con.createStatement();
	st.addBatch("insert into employee values(111,’ram’,5550.89,’hyderabad’)");
	st.addBatch("insert into employee values(112,’sam’,666.89,’secbad’)");
	st.addBatch("delete from employee where eno=102");
	st.executeBatch();
	con.commit();
	}
	catch(Exception e)
	{
	con.rollback();
	}
}
}