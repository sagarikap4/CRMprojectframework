package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	/**
	 * This method is used to create connection to DB
	 * @throws SQLException
	 */
	public void getDBConnection(String url,String UN,String PW) throws SQLException
	{
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url,UN,PW);
		}
		catch(Exception e)
		{
		}
	}
	public void getDBConnection() throws SQLException
	{
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		}
		catch(Exception e)
		{
		}
	}
	/**
	 * This method is used to close connection to DB
	 * @throws SQLException
	 */
	public void closeDBConnection() throws SQLException
	{
		con.close();
	}
	/**
	 * This method is used to ececute select query
	 * @return 
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
	ResultSet Result = null;
		try
		{
	     Statement state=con.createStatement();
         Result=state.executeQuery(query);
		}
		catch(Exception e)
		{
		}
    return Result;
	}
	/**
	 * This method is used to execute nonselect query
	 * @return 
	 */
	public int executeUpdate(String query)
	{
		int Result = 0;
		try
		{
	     Statement state=con.createStatement();
         Result=state.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
    return Result;
	}

}
