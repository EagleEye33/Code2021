// Abstract class demo
public class DemoAbstractClasses
{
	public static void main(String[] args)
	{
		// This declaration is valid
		Shape ref;

		// The following line is no longer valid
		//Shape shape = new Shape();

		// Create objects
		Square square = new Square(10);
		Rectangle rectangle = new Rectangle(20,30);
		Triangle triangle = new Triangle(3,4,5);

		ref = square;
		System.out.println("Area = "+ref.area()+"\n");

		ref = rectangle;
		System.out.println("Area = "+ref.area()+"\n");

		ref = triangle;
		System.out.println("Area = "+ref.area()+"\n");
	}
}