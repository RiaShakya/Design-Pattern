package New;

interface Shape {
	double area();
}

class Circle implements Shape {
	public double area () {
		return Math.PI * 2 * 2;
	}
}

class Square implements Shape {
	public double area() {
		return 4 * 4;
	}
}

public class OCP {
	public static void main( String [] args) {
		
		Shape s1 = new Circle();
		Shape s2 = new Square();
		
		System.out.println("Area of circle : " + s1.area());
		System.out.println("Area of square : " + s2.area());
	}
}