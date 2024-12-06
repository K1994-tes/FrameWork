package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable
	{
//		step:1- Register/Load mysql database
			Driver refDriver= new Driver();
			DriverManager.registerDriver(refDriver);
			
			//step:2- get connection to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "MYSQL1994");
			//step:3- create SQL Statement
			Statement state = conn.createStatement();
			String Query = "insert into students(id,first_name,last_name,address)values('3','kavya','g','vijayawada')";
		//step:4- execute statement /Update
			int result = state.executeUpdate(Query);
			if(result==1)
			{
				System.out.println("data is passed");
			}
			else
			{
				System.out.println("data is not passed");
			}
			//step:5- close the connection
			conn.close();

	}
}
