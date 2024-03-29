package com.kishore.jdbc;

import javax.sql.rowset.*;

import java.io.*;
public class CRSRestoreDemo
{
public static void main(String rags[]) throws Exception
{
	FileInputStream fis= new FileInputStream("temp.ser");
	ObjectInputStream ois=new ObjectInputStream(fis);
	Object o=ois.readObject();
	CachedRowSet crs=(CachedRowSet)o;
	while(crs.previous())
	{
		System.out.println(crs.getString(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t"+crs.getString(4));
	}
}
}