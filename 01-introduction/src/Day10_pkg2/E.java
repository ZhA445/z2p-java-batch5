package Day10_pkg2;

import Day10_pkg1.A;

public class E  extends A{
	
	//int b; //default -> different pkg(not inherited)
	// protected int c= 10;//protected(inherited)
	void test1() {
		// b=30;
		c=20;
		this.d=30;
		A obj = new A();
//		obj.c =20; => error, protected
		obj.d= 30; //ok , public
		
	}
	
}
