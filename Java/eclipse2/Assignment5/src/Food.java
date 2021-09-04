import java.text.NumberFormat;
public class Food extends Product{
	private String name;
	private double damageRate;
	private String expirationDate;
	
	public Food() //default constructor
	{
		this.name = "?";
		this.damageRate = 0.0;
		this.expirationDate = "08.20.2015";
	}
	
	//inherits from parent constructor and adds 3 new reference variables
	public Food(String productId, int quantity, double unitPrice, String name, double damageRate, String expirationDate) 
	{
		super(productId, quantity, unitPrice);
		this.name = name;
		this.damageRate = damageRate;
		this.expirationDate = expirationDate;
	}
	
	public void computeTotalCost()//abstract method overridden for Food class specific use case
	{
		totalCost = (unitPrice * quantity) * (1 + damageRate);
	}
	
	public String toString()// returns the current state of Food as a String
	{
		StringBuilder builder = new StringBuilder();
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
		numberFormat.setMinimumFractionDigits(2);
		
		builder.append("\nFood:");
		builder.append(super.toString());
		builder.append("Food Name:\t\t" + name + "\n");
		builder.append("Damage Rate:\t\t" + numberFormat.format(damageRate) + "\n");
		builder.append("Expiration date:\t" + expirationDate + "\n");
		
		return builder.toString();
	}
}
