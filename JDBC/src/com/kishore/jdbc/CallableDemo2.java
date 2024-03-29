package com.kishore.jdbc;

import java.sql.* ;
public class CallableDemo2
{
	public static void main( String args[])throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		CallableStatement cst=con.prepareCall("{CALL first_pro(?,?)}");
		cst.registerOutParameter(2,Types.INTEGER) ;
		cst.setInt(1,10);
		cst.execute();
		int i=cst.getInt(2);
		System.out.println("Result is: " +i);
}
}