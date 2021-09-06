package MultiLevelDemo;
public class Box
{
	private double width;
	private double height;
	private double depth;

	//Default constructor
	Box()
	{
		width=-1;
		depth=-1;
		height=-1;
	}

	// Constructor when all dimensions are specified
	Box(double width, double height, double depth)
	{
		this.width=width;
		this.height=height;
		this.depth=depth;
	}

	// Constructor to create a clone object of Box
	Box(Box obj)
	{
		width=obj.width;
		height=obj.height;
		depth=obj.depth;
	}

	// Class method to compute the volume of a box
	double volume()
	{
		return width*height*depth;
	}
}