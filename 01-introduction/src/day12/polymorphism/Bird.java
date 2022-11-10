package day12.polymorphism;

public class Bird implements Flying{

	@Override
	public void fly() {
		System.out.println("Bird fly with wings");
	}
}
