class Square extends Shape
{
	// Constructor to create a sqaure of a given length "side"
	Square(double side)
	{
		super(side);
	}

	// Overrides parent Shape's area() method to return the area of a square
	double area()
	{
		System.out.println("Inside Square's area() method.");
		return dim1*dim1;
	}
}