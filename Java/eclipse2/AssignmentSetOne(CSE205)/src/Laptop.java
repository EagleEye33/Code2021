import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
public class Laptop {

		private String BrandName;
		private Model model = new Model();
		private double price;
		
		//access and mutator methods
		public String getBrand()
		{
			return BrandName;
		}
		
		public Model getModel()
		{
			return model;
		}
		
		public double getPrice()
		{
			return price;
		}
		
		public void setBrand(String newBrand)
		{
			BrandName = newBrand;
		}
		
		//Updates the variables from the Model class
		public void setModel(String newModel, double newCPU, int newRAM)
		{
		model.setModel(newModel);
		model.setCPU(newCPU);
		model.setRAM(newRAM);
		}
		
		public void setPrice(double newPrice)
		{
			price = newPrice;
		}
		
		//Returns a string of all the variables and formats the price variable to 2 decimals places
		public String toString()
		{
			DecimalFormat df = new DecimalFormat("0.00");
			return ("\nBrand:\t" + BrandName +"\n" + model.toString() +"\n" + "Price:\t" + "$" + df.format(price) + "\n\n");
		}

}
