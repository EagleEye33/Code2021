package MultiLevelDemo;
public class DemoShipment
{
	public static void main(String[] args)
	{
		// Create 2 object of class Shipment with Width,Height,Depth,Weight,Cost
		Shipment shipment1=new Shipment(5,4,3,20,5.99);
		Shipment shipment2=new Shipment(10,20,30,40,50);

		// To store the volume of a box
		double volume;

		// Print the dimensions and shipping costs of the two boxes
		volume=shipment1.volume();
		System.out.println("Volume of the box for shipment 1 is = "+volume);
		System.out.println("Weight of shipment1 box is = "+shipment1.weight);
		System.out.println("Cost of shipping shipment1 is = $"+shipment1.calcCost());
		System.out.println("\n\n");
		
		volume=shipment2.volume();
		System.out.println("Volume of the box for shipment 1 is = "+volume);
		System.out.println("Weight of shipment1 box is = "+shipment2.weight);
		System.out.println("Cost of shipping shipment1 is = $"+shipment2.calcCost());
		System.out.println("\n\n");
		// To show that the parent class has access to all subclasses
		Box box1 = shipment2;

		System.out.println("Box objects can access W,H,D only! ");
		System.out.println("Trying to access subclass variables it does not know will cause an error!");
		System.out.println("Volume of box = "+box1.volume());
		/* Remove this comment to get an error!*/
		//System.out.println("Weight of box = "+box1.weight);
	}
}

// To cast Box objects into Shipment
// Box box = new Box();
// Shipment ship = (Shipment) box;