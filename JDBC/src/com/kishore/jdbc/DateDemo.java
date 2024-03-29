package com.kishore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class DateDemo
{
public static void main(String args[])throws Exception
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","system");
	PreparedStatement pst = con.prepareStatement("insert into wishes values(?,?)");
	Scanner sn= new Scanner(System.in);
	System.out.println("enter name");
	String s1=sn.nextLine();
	sn.nextLine();
	System.out.println("enter Date of Birth");
	String s2 = sn.nextLine();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	java.util.Date d1 =sdf.parse(s2);
	long ms=d1.getTime();
	java.sql.Date d2= new java.sql.Date(ms);
	pst.setString(1,s1);
	pst.setDate(2,d2) ;
	pst.executeUpdate();
	pst.close();
	con.close();
	sn.close();
}}
