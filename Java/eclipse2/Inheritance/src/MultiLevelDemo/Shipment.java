package MultiLevelDemo;
public class Shipment extends BoxWeight
{
	// Adds the shipping price for a box
	double cost;

	// Default constructor
	Shipment()
	{
		super();
		cost=-1;
	}

	// Constructor to clone an object of Shipment
	Shipment(Shipment obj)
	{
		super(obj);
		cost=obj.cost;
	}

	// Constructor when all parameters are known
	Shipment(double width, double height, double depth, double weight, double cost)
	{
		super(width, height, depth, weight);
		this.cost=cost;
	}

	// Method to calculate the cost of shipping a box
	double calcCost()
	{
		// volume() is called from the Box superclass
		return 0.25*volume()*weight*cost;
	}
}