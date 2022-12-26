import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		int i = 1;
		int factorial = 2;
		int n;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter int n: ");
		n = sc.nextInt();
		
//		for(int a = 0; a< num; a++) {
//			factorial *= i;
//		}
		while(i < n ) {
			factorial *= i;
			i++;
		}
		System.out.println("Factorial :" + factorial );
	}
}
