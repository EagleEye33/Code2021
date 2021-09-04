public class Clothing extends Product{
	private String size;
	private String color;
	//no variables need to be initialized here. 
	
	public Clothing(String productId, int quantity, double unitPrice, String size, String color)//Constructor for passing in values for Clothing object
	{
		super(productId, quantity, unitPrice);
		this.size = size;
		this.color = color;
	}
	
	public void computeTotalCost()//overridden abstract method to compute the total cost of a Clothing object
	{
	totalCost = unitPrice * quantity;	
	}
	
	public String toString()// returns the current state of Clothing as a String
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("\nClothing:");
		builder.append(super.toString());
		builder.append("Size:\t\t\t");
		builder.append(size + "\n");
		builder.append("Color:\t\t\t");
		builder.append(color + "\n");
		
		return builder.toString();
	}
	
	
}
