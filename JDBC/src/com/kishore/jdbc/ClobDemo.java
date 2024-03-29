package com.kishore.jdbc;

import java.io.*;
import java.sql.*;
class ClobDemo{
	public static void main(String[] args) throws IOException,SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver( ));
		Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","system");
		PreparedStatement stmt = con.prepareStatement("update text set col1 = ? where col2=100");
		File f= new File("abc.txt");
		FileReader fr = new FileReader(f);
		//store the file into col1 as character stream
		stmt.setCharacterStream(1,fr,(int)f.length());
		//display the file size
		System.out.println("FileSize"+f.length());
		System.out.println("NO of rows effected "+stmt.executeUpdate());
		stmt.close();
		con.close();
}
}