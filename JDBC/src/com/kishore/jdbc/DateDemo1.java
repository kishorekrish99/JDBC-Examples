package com.kishore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class DateDemo1
{
public static void main(String args[])throws Exception
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe ","system","system");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select dob from wishes where sname=’ram'");
	rs.next();
	java.sql.Date d1=rs.getDate(1);
	java.util.Date d2=(java.util.Date)d1;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
	String s=sdf.format(d2);
	System.out.println(s);
	rs.close();
	con.close();
}}