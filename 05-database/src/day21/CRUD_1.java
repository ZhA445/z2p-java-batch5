package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD_1 {

	public static void main(String[] args) {
		var url = "jdbc:mariadb://localhost:3306/batch5";
		var user_name = "root";
		var password = "Zha@2017";
		//get user input
		try(Scanner sc = new Scanner(System.in)){
			Connection con = DriverManager.getConnection(url,user_name,password);
			
			//get user input
			System.out.println("Enter item name: ");
			String input_name = sc.nextLine();
			System.out.println("Enter price: ");
			float input_price = Float.parseFloat(sc.nextLine());
			
			//save to db
			//statement(con,input_name,input_price);
			preparedStatement(con, input_name,input_price);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void preparedStatement(Connection con, String input_name, float input_price) throws SQLException {
		//var query = "INSERT INTO products(name,price)VALUES('" +input_name+"'," + input_price +")";
		var query = "INSERT INTO products(name,price)VALUES(?,?)";
		
		//create prepare st
		PreparedStatement pst = con.prepareStatement(query);
		
		//define param value (pst.setXXX(position,value);)
		pst.setString(1, input_name);
		pst.setFloat(2, input_price);
		
		
		//execute
		pst.executeUpdate();
		System.out.println("success...");
	}

	private static void statement(Connection con, String input_name, float input_price) throws SQLException {
		var query = "INSERT INTO products(name,price)VALUES('" +input_name+"'," + input_price +")";
		System.out.println("query => " + query);
		
		//create st
		Statement st = con.createStatement();
		
		//execute
		st.executeUpdate(query);
		
		System.out.println("success");
		
	}

	
}
