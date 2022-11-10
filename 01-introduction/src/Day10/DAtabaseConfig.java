package Day10;

public class DAtabaseConfig {

	String db_name = "employeedb";
	//static field
	private static DAtabaseConfig obj = null;
	
	//private constructor
	private DAtabaseConfig() {
		
	}
	
	//static method
	public static DAtabaseConfig getInstance() {
		if(obj == null) {
			obj = new DAtabaseConfig();
		}
		return obj;
	}
	class Teacher{//inner class
		
	}
	
}

class Student{
	
}
