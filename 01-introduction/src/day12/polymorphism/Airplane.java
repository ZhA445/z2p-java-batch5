package day12.polymorphism;

public class Airplane implements Flying{

	@Override
	public void fly() {
		System.out.println("Airplanes fly with the engine");
	}
}
