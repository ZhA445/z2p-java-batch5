import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testing {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mariadb://localhost:3306/";
		String username = "root";
		String password = "Zha@2017";
		
		
		//create connection
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("got connection");
		
		//create statement
		
		Statement st = con.createStatement();
		System.out.println("create statement success.");
		
		String query = """
				INSERT INTO employees(emp_no,emp_name,city,salary,bonus,bithday)
				VALUES(1003,'cherry','Yangon',400000,0.0,'2000-5-6')
				""";
		
	}
}
