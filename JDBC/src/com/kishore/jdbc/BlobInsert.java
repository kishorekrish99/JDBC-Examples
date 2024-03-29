package com.kishore.jdbc;

import java.sql.*;
import java.io.*;
class BlobInsert
{
	public static void main(String args[]) throws Exception{
		File f = new File("t9.gif");
		FileInputStream fis =new FileInputStream(f);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con
		=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?)");
		stmt.setInt(1,101);
		stmt.setBinaryStream(2,fis,(int)f.length());
		stmt.executeUpdate();
		System.out.println("image inserted");
		con.close();
	}
}