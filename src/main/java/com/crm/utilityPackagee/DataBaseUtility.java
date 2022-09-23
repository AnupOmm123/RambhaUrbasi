package com.crm.utilityPackagee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	/**
	 * this method is used to connect to db
	 * @param DBname
	 */
	public void connectionToDB(String DBname)
	{
		try {
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			DriverManager.getConnection(IConstants.DbUrl+DBname,IConstants.DbUserName,IConstants.DbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is used to close the database
	 */
	public void closeDB()
	{
		try {
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	/**
	 * this method is used to execute query
	 * @param query
	 * @param coloumnNum
	 * @param ExpectedData
	 * @return
	 * @throws SQLException
	 */
public boolean executeQuery(String query,int coloumnNum,String ExpectedData) throws SQLException
{
	result=connection.createStatement().executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		if(result.getString(coloumnNum).equals(ExpectedData))
		{
			flag=true;
			break;
		}
	}
	if(flag)
	{
			System.out.println("data is present");
			return flag;
			
		}
		else {
			System.out.println("data is not presented");
			return flag;
			
		}
	
}
/**
 * this method is used to perform execute update
 * @param query
 * @throws SQLException
 */
public void exicuteUpdate(String query) throws SQLException
{
	int res=connection.createStatement().executeUpdate(query);
	if(res==1)
	{
		System.out.println("data is updated");
		
	}
	else {
		System.out.println("data is not updated");
	}
}public void connectToDB()
{
	System.out.println("database connection is successful");
}
/**
 * Closing DB
 */
public void closeDB1()
{
	System.out.println("close DB connection");
}
}
