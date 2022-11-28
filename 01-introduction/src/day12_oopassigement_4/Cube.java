package day12_oopassigement_4;

public class Cube implements Shape{

	private int x;
	
	public Cube(int x) {
		super();
		this.x = x;
	}

	@Override
	public double Area() {
		double area = 6 * x * x;
		return area;
	}

	@Override
	public double Volume() {
		double volume = x * x * x;
		return volume;
	}

}
