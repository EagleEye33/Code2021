import java.text.NumberFormat;

abstract class Product {
	protected String productId;
	protected int quantity;
	protected double unitPrice;
	protected double totalCost;
	
	public Product() //default constructor initializes variables
	{
		this.productId = "?";
		this.quantity = 0;
		this.unitPrice = 0.0;
	}
	
	public Product(String productId, int quantity, double unitPrice)//constructor for passing in values
	{
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public String getProductId()//accessor method to retrieve the private variable productId
	{
		return productId;
	}
	
	public abstract void computeTotalCost();//abstract method that will be overridden in child classes for separate use cases
	
	public String toString()// returns the current state of the Product as a String
	{
		StringBuilder builder = new StringBuilder();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		builder.append("\nProduct ID:\t\t" + productId + "\n");
		builder.append("Quantity:\t\t" + quantity + "\n");
		builder.append("Unit Price:\t\t" + nf.format(unitPrice) + "\n");
		builder.append("Total Cost:\t\t" + nf.format(totalCost) + "\n");
		
		return builder.toString();
	}
	
}
