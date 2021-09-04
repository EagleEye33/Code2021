package RuntimePolymorphism;
// Method Overriding and Runtime Polymorphism Demo
public class DemoRuntimePolymorphism
{
	public static void main(String[] args)
	{
		Shape ref;

		Shape shape = new Shape();
		Square square = new Square(10);
		Rectangle rectangle = new Rectangle(20,30);
		Triangle triangle = new Triangle(3,4,5);

		ref = shape;
		System.out.println("Area = "+ref.area()+"\n");

		ref = square;
		System.out.println("Area = "+ref.area()+"\n");

		ref = rectangle;
		System.out.println("Area = "+ref.area()+"\n");

		ref = triangle;
		System.out.println("Area = "+ref.area()+"\n");
	}
}