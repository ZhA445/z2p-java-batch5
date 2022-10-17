package day2;

public class Testing_1 {
	 
	//	global place(outside all method) -fields 
	private int num2; //instance field/variable
	boolean flag; //instance field/variable
	private static int num3; //static field/variable
	
//	var name="Su Su";<- can't use var in global 
	public void display() {//instance method
		//static int num1=0; <- can't use access modifiers in local
		//private int num1 =0;
		//int num1;
		int num1= 0;
		System.out.println("Num1= " + num1);
		System.out.println("Num2= " + num2);//0
		System.out.println("flag = " + flag);//false
		
		var num2=100; //<- var can auto translate int, float,bool,string
		var num3= 3.5;
		var num4="Zin Htet";
		var num5=true;
		show();
		init();
//		var num5=null; <-can't use null in local
	}
//	object = instance
	public void show() {
		
	}
	
	public static void init() {
		//just call only static data(variable or method)
//		show();<-can't call 
		add(); //static method
//		System.out.println("Num2 =" + num2); <instance variable
		System.out.println("Num3 = " + num3); //<static variable
	}
	
	public static void add() {
		
	}
	
	public static void main(String[] args) {//static method
		Testing_1 obj = new Testing_1();//Create obj
		obj.display();
		System.out.println("Num2= " + obj.num2);
		
	}
}
