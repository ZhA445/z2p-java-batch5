package day12.polymorphism;

public interface MyInterface {

	void abstract_method1();
	
	static void static_method() {
		System.out.println("This is static method.It can't be overriden.");
	}
	
	default void default_method() {
		System.out.println("This is default method.It can be overriden.");
	}
	
	private void private_method() {
		System.out.println("This is private method.It can't not be overriden.");
	}
}
