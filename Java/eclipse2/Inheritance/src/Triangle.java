class Triangle extends Shape
{

	// Constructor to create a triangle with 3 given sides
	Triangle(double side1, double side2, double side3)
	{
		super(side1,side2,side3);
	}

	// Overrides parent Shape's area() method to return the area of a triangle
	double area()
	{
		System.out.println("Inside Triangle's area() method.");
		double s = (dim1 + dim2 + dim3)/2;
		double a = Math.sqrt(s*(s-dim1)*(s-dim2)*(s-dim3));
		return a;
	}
}