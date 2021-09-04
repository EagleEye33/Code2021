package MultiLevelDemo;
public class BoxWeight extends Box
{
	// Adds weight to the box
	double weight;

	// Default constructor
	BoxWeight()
	{
		super();
		weight=-1;
	}

	// Constructor when all parameters are given
	BoxWeight(double width, double height, double depth, double weight)
	{
		super(width,height,depth);
		this.weight=weight;
	}

	// Constructor to clone an object of BoxWeight
	BoxWeight(BoxWeight obj)
	{
		super(obj);
		weight=obj.weight;
	}
}