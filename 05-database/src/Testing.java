import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testing {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mariadb://localhost:3306/batch12";
		String username = "root";
		String password = "Zha@2017";
		
		
		//2 create connection
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("got connection");
		
		//3 create statement
		
		Statement st = con.createStatement();
		System.out.println("create statement success.");
		
		//4 execute query
		String query = """
				INSERT INTO employees(emp_no,emp_name,salary,bonus,birthday,city)
				VALUES(1003,'cherry',400000,0.0,'2000-5-6','Yangon')
				""";
		int numbers = st.executeUpdate(query);
		if(numbers > 0) {
			System.out.println("success");
		}
		else {
			System.out.println("Something is wrong");
		}
		
		//5.close connection
		con.close();
	}
}
