package day12_oopassigement_3;

public class Rectangle extends Shape{

	private int length;
	private int width;
	
	public Rectangle(String color, int length, int width) {
		this.getColor();
		this.length = length;
		this.width = width;
	}

	@Override
	public double Area() {
	double	area = this.length * this.width;
		return area;
	};
	
	public void displayArea() {
		System.out.println("Rectangle of area: " + Area());
	}
}
