package com.kishore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class RSMD
{
public static void main( String args[]) throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	Statement stmt=con.createStatement();
	ResultSet rs =stmt.executeQuery("select * from employee");
	ResultSetMetaData rsmd=rs.getMetaData();
	for(int i=0;i<rsmd.getColumnCount( );i++)
	System.out.print( rsmd.getColumnLabel(i+1)+"\t");
	System.out.println();
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+ rs.getDouble(3)+"\t"+rs.getString(4));
	}
	rs.close();
	stmt.close();
	con.close();
}
}