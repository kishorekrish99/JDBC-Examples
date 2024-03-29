package com.kishore.jdbc;

import java.sql.*;
import java.io.*;
class BlobGet
{
public static void main(String args[]) throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	Statement stmt =con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from emp");
	rs.next();
	Blob b =rs.getBlob(2);
	System.out.println("picture is Retrived");
	FileOutputStream fos = new FileOutputStream("h.gif");
	byte ab[]=b.getBytes(1,(int)b.length());
	fos.write(ab);
	con.close();
	fos.close();
}
}