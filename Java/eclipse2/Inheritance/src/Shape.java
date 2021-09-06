/*
Abstract Parent class. Has three dimensions as class variables and one abstract method area() which can be
overridden by its child classes.
*/
abstract class Shape
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

	// Abstract method that should be overridden by subclasses
	abstract double area();
}