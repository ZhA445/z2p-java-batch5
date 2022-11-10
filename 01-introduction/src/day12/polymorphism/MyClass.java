package day12.polymorphism;

public class MyClass implements MyInterface{

	@Override
	public void abstract_method1() {
		System.out.println("This is abstract method.");
	}
	
	@Override
	public void default_method() {
		System.out.println("This is customized default method.");
	}
}
