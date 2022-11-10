package day11.abstraction;

import java.util.List;

public class Demo {

	public static void main(String[] args) {
		//DataBaseUtil util = new DataBaseUtil() ; //can't create object
		
		DataBaseUtil util = new ProductService();
		util.connect_database();
		util.insert();
		util.update();
		util.delete(1001);
		util.findById(1002);
		util.findAll();
		
		System.out.println("--------");
		util = new CategoryService();
		util.insert();
		util.update();
	}
}
