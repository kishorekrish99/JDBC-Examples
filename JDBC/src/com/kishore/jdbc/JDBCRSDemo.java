package com.kishore.jdbc;

import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;
import java.io.*;
public class JDBCRSDemo
{
public static void main(String rags[]) throws Exception
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	JdbcRowSet jrs=new JdbcRowSetImpl();
	jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	jrs.setUsername("system");
	jrs.setPassword("system");
	jrs.setCommand("select * from employee");
	jrs.execute();
	ResultSetMetaData meta=jrs.getMetaData();
	int colCount=meta.getColumnCount();
	while(jrs.next())
	{
	for(int i=1;i<=colCount;i++)
	{
	System.out.print(jrs.getString(i)+"\t");
	}
	System.out.println();
	}//while()
	new ObjectOutputStream(new FileOutputStream("temp.ser")).writeObject(jrs);
	}//main()
}//class