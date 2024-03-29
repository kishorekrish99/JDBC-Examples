package com.kishore.jdbc;

import java.io.*;
import java.sql.*;
public class ClobGet
{
public static void main(String[] args) throws Exception
{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver( ));
	Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","system");
	Statement stmt=con.createStatement();
	ResultSet rs =stmt.executeQuery("select * from text");
	rs.next();
	Clob c = rs.getClob("col1");
	System.out.println("file size="+c.length());
	Reader r=c.getCharacterStream();
	FileWriter fw= new FileWriter("ba.txt",true);
	int ch;
	while((ch=r.read()) != -1)
	{
	System.out.print((char)ch);
	fw.write((char)ch);
	}
	fw.close();
	con.close();
}}