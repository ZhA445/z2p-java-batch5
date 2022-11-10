package day13;

public class Demo2 {

	public static void main(String[] args) {
		Massage msg = (str) -> System.out.println("Data: " + str);
		
		msg.display("Hello");
		
		Authentication auth = (mail,pass)->{
			if(mail.equals("admin@gmail.com") && pass.equals("admin"))
				return true;
			else
				return false;
					
		};
		boolean result = auth.login("admin@gmail.com", "admin");
		if(result)
			System.out.println("Login Success.");
		else
			System.out.println("Login Fail");
	}
}

@FunctionalInterface
interface Massage{
	void display(String input);
}

@FunctionalInterface
interface Authentication{
	boolean login(String email, String pass);
}
