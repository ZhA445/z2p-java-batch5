package Day10_pkg1;

public class A {

	private int a = 10; //private (console.log(obj.a))
	int b= 10;//default 
	protected int c = 10;//protected
	public int d = 20;
	
	public void set_A_value(int input) {
		this.a= input;
	}
	
	public int view_A_vlaue() {
		return this.a;
	}
	
//	public int getA() {
//		return this.a;
//	}
	
	public void test() {
		a= 20;
		b=20;
		c=20;
		d = 30;
	}
}