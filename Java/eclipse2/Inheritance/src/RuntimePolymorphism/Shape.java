package RuntimePolymorphism;
/*
Parent class. Has three dimensions as class variables and one method area() which can be
overridden by its child classes.
*/
public class Shape
{
	double dim1;
	double dim2;
	double dim3;

	// Default constructor
	Shape()
	{
		dim1 = -1;
		dim2 = -1;
		dim3 = -1;
	}

	// Constructor for 1-D shapes
	Shape(double dim1)
	{
		this.dim1 = dim1;
	}

	// Constructor for 2-D shapes
	Shape(double dim1, double dim2)
	{
		this.dim1 = dim1;
		this.dim2 = dim2;
	}

	// Constructor for 3-D shapes
	Shape(double dim1, double dim2, double dim3)
	{
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
	}

	// Method that should be overridden by subclasses
	double area()
	{
		System.out.println("General area of shapes does not exist!");
		return -1;
	}
}