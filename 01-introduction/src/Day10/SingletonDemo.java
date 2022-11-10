package Day10;

public class SingletonDemo {
	public static void main(String[] args) {
		DAtabaseConfig config1 = DAtabaseConfig.getInstance();
		System.out.println("db_name: "+ config1.db_name);
		
		DAtabaseConfig config2 = DAtabaseConfig.getInstance();
		System.out.println("db_name: " + config2.db_name);
		
		config2.db_name = "dtudentdb";
		System.out.println("cnift1's db_name: " + config1.db_name);
	}
	
}
