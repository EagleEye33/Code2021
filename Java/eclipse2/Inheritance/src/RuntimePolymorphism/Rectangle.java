package RuntimePolymorphism;
public class Rectangle extends Shape
{

	// Constructor to create a rectangle of given length and width
	Rectangle(double length,double width)
	{
		super(length,width);
	}

	// Overrides parent Shape's area() method to return the area of a rectangle
	double area()
	{
		System.out.println("Inside Rectangle's area() method.");
		return dim1*dim2;
	}
}
