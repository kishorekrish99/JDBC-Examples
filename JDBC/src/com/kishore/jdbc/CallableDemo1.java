package com.kishore.jdbc;

import java.sql.*;
public class CallableDemo1
{
public static void main(String args[])throws Exception{
	oracle.jdbc.driver.OracleDriver od=new oracle.jdbc.driver.OracleDriver();
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	CallableStatement cst=con.prepareCall("{?=call myfunction(?)}");
	cst.setInt(2,5);
	cst.registerOutParameter(1,Types.INTEGER);
	cst.execute();
	System.out.println("Value returned by function =" + cst.getInt(1));
}
}