package com.kishore.jdbc;

import java.sql.*;
import java.util.*;
public class DropTable
{
	public static void main(String[] args){
		Connection con=null;
		Statement st=null;
		Scanner s=null;
		try
		{
			s=new Scanner(System.in);
			System.out.println("Enter table name to delete ");
			String tab=s.next();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:ksreddyDSN","system","system");
			st=con.createStatement();
			st.executeUpdate("drop table "+tab);
			System.out.println("deleted table is"+tab);
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println(cnf);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		}
}