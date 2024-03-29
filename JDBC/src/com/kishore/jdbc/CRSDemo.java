package com.kishore.jdbc;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.*;
public class CRSDemo
{
public static void main(String args[]) throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select *from employee");
	CachedRowSet crs = new CachedRowSetImpl();
	crs.populate(rs);
	con.close();

	while(crs.next())
	{
		System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getDouble(3)+"\t"+crs.getString(4));
	}
	new ObjectOutputStream(new FileOutputStream("temp.ser")).writeObject(crs);
	crs.close();
	stmt.close();
}
}