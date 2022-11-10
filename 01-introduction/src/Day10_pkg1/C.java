package Day10_pkg1;

public class C extends A{

	//private int a; //can't inherit
	//int b = 10;
	//protected int c = 10;
	
	void test1 () {
		//a= 20; //error , private(not inherit)
		b= 20; //ok , default(inherited)
		c=20; //ok. protected(inherited)
		d= 40;//ok  ,public(inherited)
	}
}
