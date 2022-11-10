package Day10_inheritance;

public class MethodOverriding {

	public static void main(String[] args) {
		Cat obj = new Cat();
		obj.sound();
		obj.show();
		
		System.out.println("-----------");
		Animal obj2 = new Animal();
		obj2.sound();//default
		
		obj2 = obj; //obj2=> cat
		obj2.sound();//overriding
	}
}

class Animal{
	void show() {
		System.out.println("This is show method");
	}
	void sound() {
		System.out.println("Speak with some sound");
	}
}

class Cat extends Animal{
	@Override
	void sound() { //overriding
		System.out.println("Myaung");
	}
}