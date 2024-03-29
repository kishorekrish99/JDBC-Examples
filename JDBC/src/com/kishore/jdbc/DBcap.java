package com.kishore.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
public class DBcap
{
public static void main(String args[])throws Exception
{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	DatabaseMetaData dbmd =con.getMetaData();
	System.out.println("database name "+dbmd.getDatabaseProductName());
	System.out.println("database version "+dbmd.getDatabaseProductVersion());
	System.out.println("jdbc driver version "+dbmd.getDriverVersion());
	System.out.println("usesLocalFiles"+dbmd.usesLocalFiles());
	System.out.println("sql key words ="+dbmd.getSQLKeywords());
	System.out.println("numeric functions "+dbmd.getNumericFunctions());
}
}
