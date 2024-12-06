package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchingDataFromDatabase {

	public static void main(String[] args) throws Throwable
	{
	//	step:1- Register/load mysql database
		Driver refDriver= new Driver();
		DriverManager.registerDriver(refDriver);
		
		//step:2- get conection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "MYSQL1994");
		
		//step:3- create SQL Statement
		Statement state = conn.createStatement();
		String Query = "select * from students";
		
		//step:4- execute statement/Query
		ResultSet result = state.executeQuery(Query);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		//step:5- close the connection
		conn.close();
		}
		
	}


