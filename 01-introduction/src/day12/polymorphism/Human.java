package day12.polymorphism;

public class Human implements Flying{

	@Override
	public void fly() {
		System.out.println("Human fly with parachute");
	}
}
