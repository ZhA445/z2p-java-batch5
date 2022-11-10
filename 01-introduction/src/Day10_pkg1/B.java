package Day10_pkg1;

public class B {
	
	void test() {
		A obj = new A();
		//obj.a =30; //error,,can't access, private (outside the class)
		obj.b =200; //ok , default(within the same pkg)
		obj.c = 20;//ok, protected 
		obj.d =30;//public
		
		obj.set_A_value(20);
		System.out.println("a= "+ obj.view_A_vlaue());
	}
	
	public static void main(String[] args) {
		new B().test();
	}
}
