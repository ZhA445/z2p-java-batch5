package day8;

public class CustomException {
		
	static void validateAge(int age) throws InvalidAgeException{
		if(age < 18) {
			throw new InvalidAgeException("Age is not allowed");
		}
		else {
			System.out.println("you can smoke.");
		}
	}
		public static void main(String[] args) {
			try {
				validateAge(12);
			} catch (InvalidAgeException e) {
				System.err.print(e.getMessage());
			}
		}
}

class InvalidAgeException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public InvalidAgeException(String msg) {
		super(msg);
	}
}