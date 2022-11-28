package day12_oopassigement_4;

public class Circle implements Shape{

	private int radius;
	
	public Circle(int r) {
		super();
		this.radius  = r;
	}
	@Override
	public double Area() {
		double area = 3.142 * (radius * radius);
		return area;
	}

	@Override
	public double Volume() {
		return 0;
	}

	
}
